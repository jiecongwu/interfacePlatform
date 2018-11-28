/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

package io.renren.common.utils.outter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import io.renren.common.utils.DESUtil;
import io.renren.common.utils.IDUtil;

/**
 * <pre>
 * REST接口调用客户端
 * </pre>
 * 
 * @author chenqiang chenqiang@foresee.com.cn
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 */
public class FtcspRestClient {

    private static final Log    log                    = LogFactory.getLog(FtcspRestClient.class);

    private static final String APPLICATION_JSON       = "application/json;charset=UTF-8";

    //private static final String APPLICATION_JSONX      = "application/jsonx";

    private static final String CONTENT_TYPE_TEXT_JSON = "text/json;charset=UTF-8";

    String                      appId;

    private String              appDesKey;

    private String              appSignKey;

    private String              sessionId;

    private String              username;

    private String              password;

    /**
     * Content-Type。
     */
    private String              contentType;

    /**
     * 响应状态代码。
     */
    private int                 responseCode;

    /**
     * 响应内容。
     */
    private String              responseContent;


    /**
     * 构造函数，默认是安全模式。
     */
    public FtcspRestClient(String appId) {
        this(appId, null, null, null);
    }

    public FtcspRestClient(String appId, String sessionId) {
        this(appId, sessionId, null, null);
    }

    public FtcspRestClient(String appId, String appDesKey, String appSignKey) {
        this(appId, null, appDesKey, appSignKey);
    }

    /**
     * 构造函数。
     * 

     */
    public FtcspRestClient(String appId, String sessionId, String appDesKey, String appSignKey) {

        //        if (securityMode) {
        //            contentType = APPLICATION_JSONX;
        //        } else {
        //            contentType = APPLICATION_JSON;
        //        }

        contentType = APPLICATION_JSON;

        this.appId = appId;
        this.appDesKey = appDesKey;
        this.appSignKey = appSignKey;
        this.sessionId = sessionId;

        if (this.sessionId == null) {
            this.sessionId = IDUtil.getUUID();
        }
    }

    /**
     * POST数据。
     * 
     * @param url String
     * @param data String
     * @return boolean
     */
    public boolean post(String url, String data, String requestId) {
        return request(true, url, data, requestId);
    }

    /**
     * POST数据。
     * 
     * @param url String
     * @param data String

     * @return boolean
     */
    public boolean post(String url, String data) {
       return request(true, url, data, null);
    }
    public List post1(String url, String data) {
        // return request(true, url, data, null);
     	return request1(true, url, data, null);
     }
    /**
     * 请求服务器URL。
     * 
     * @param url
     * @return
     */
    public boolean get(String url) {
        return get(url, null);
    }

    /**
     * 请求服务器URL。
     * 
     * @param url

     * @return
     */
    public boolean get(String url, String requestId) {
        return request(false, url, null, requestId);
    }

    /**
     * 请求接口
     * 
     * @param data String

     * @return boolean
     */
    private boolean request(boolean isPost, String url, String data, String requestId) {
        // 重置响应内容
        responseContent = null;
        
      //  url = FtcspRestUtils.resolveURL(url, true);

        if (log.isDebugEnabled()) {
            log.debug("Post: " + url + ", Data: " + data);
        }

        if (requestId == null) {
            requestId = IDUtil.getUUID();
        }

        long timestamp = System.currentTimeMillis();

        if (url.indexOf("?") < 0) {
            url = url + "?";
        } else {
            url = url + "&";
        }
        url = url + String.format("appId=%s&sessionId=%s&requestId=%s&timestamp=%s", appId, sessionId, requestId,
                String.valueOf(timestamp));

        if (data == null) {
            data = "";
        }

        String signedText = null;

        boolean isEncypted = false;
        if (appSignKey != null && appDesKey != null) {
            //getSignText( String requestId,String appId,String appSignKey,String data, long timestamp,String sessionId)
            signedText = getSignText(requestId,appId,appSignKey,data, timestamp,sessionId);

            data = desData(appDesKey,data);
             System.out.println("data:"+data);
            url = url + String.format("&sign=%s", signedText);
            System.out.println("url:"+url);

            isEncypted = true;
        }

        HttpUriRequest httpUriRequest;
        if (isPost) {
            httpUriRequest = new HttpPost(url);
        } else {
            httpUriRequest = new HttpGet(url);
        }

        // 设置头信息
        httpUriRequest.addHeader("Content-Type", contentType);
        httpUriRequest.addHeader("Accept", contentType);
        httpUriRequest.addHeader("Accept-Charset", "UTF-8");

        CloseableHttpClient httpclient;

        // 设置安全凭证
        if (username != null) {
            BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(new AuthScope(httpUriRequest.getURI().getHost(), httpUriRequest.getURI().getPort()),
                    new UsernamePasswordCredentials(username, password));
            httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        } else {
            httpclient = HttpClients.custom().build();
        }

        // 设置请求数据
        if (httpUriRequest instanceof HttpPost && data != null) {
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            stringEntity.setContentType(CONTENT_TYPE_TEXT_JSON);
            //外网需要注释，内网不需要。
            //stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            ((HttpPost) httpUriRequest).setEntity(stringEntity);
        }

        // 请求数据
        boolean result = requestData(httpclient, httpUriRequest);

        // 解密数据
        if (result && isEncypted && responseContent != null) {
            try {
               responseContent = DESUtil.decrypt(responseContent, appDesKey, true);

            } catch (Exception e1) {
                RuntimeException e = new RuntimeException(e1);
                log.error(e);
                throw e;
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Response Content: " + responseContent);
        }

        return result;
    }
    
   /*加密*/ 
    private List request1(boolean isPost, String url, String data, String requestId) {
        // 重置响应内容
        responseContent = null;
        
       // url = FtcspRestUtils.resolveURL(url, true);

        if (log.isDebugEnabled()) {
            log.debug("Post: " + url + ", Data: " + data);
        }

        if (requestId == null) {
            requestId = IDUtil.getUUID();
        }

        long timestamp = System.currentTimeMillis();

        if (url.indexOf("?") < 0) {
            url = url + "?";
        } else {
            url = url + "&";
        }
     //  url=url+
        url =url+ String.format("appId=%s&sessionId=%s&requestId=%s&timestamp=%s", appId, sessionId, requestId,
                String.valueOf(timestamp));
        
      //  return url;
        List<String> urldata = new ArrayList<String>();

        if (data == null) {
            data = "";
        }

        String signedText = null;

        boolean isEncypted = false;
        if (appSignKey != null && appDesKey != null) {
            //getSignText( String requestId,String appId,String appSignKey,String data, long timestamp,String sessionId)
            signedText = getSignText(requestId,appId,appSignKey,data, timestamp,sessionId);

            data = desData(appDesKey,data);

            url = url + String.format("&sign=%s", signedText);
             urldata.add(url);
             urldata.add(data);

            isEncypted = true;
        }

        
        return urldata; 
    }
    
    
    
    /**
     * 加密数据
     * @param appDesKey :数据秘钥
     * @param data      :待加密的数据
     * @return String
     */
    private String desData(String appDesKey,String data) {
        // 加密数据
        try {
            data = DESUtil.encrypt(data, appDesKey);
        } catch (Exception e1) {
            RuntimeException e = new RuntimeException(e1);
            log.error(e);
            throw e;
        }
        return data;
    }
    /**
     * 获取签名数据
     * @param requestId :请求流水ID
     * @param appId     :应用APPID
     * @param appSignKey:应用签名KEY
     * @param data      :需要加密的数据
     * @param timestamp :时间戳
     * @param sessionId :会话编号
     * @return String
     */
    private String getSignText( String requestId,String appId,String appSignKey,String data, long timestamp,String sessionId) {
        String signedText;
        // 签名数据
        String messageText = MessageFormat.format("{0}{1}{2},{3},{4},{5},{6}{7}",
                new Object[] { data, "{", appId, appSignKey, sessionId, requestId, String.valueOf(timestamp), "}" });

        MessageDigestPasswordEncoder mde = new MessageDigestPasswordEncoder("SHA-256", true);
        signedText = new Md5PasswordEncoder().encodePassword(mde.encodePassword(messageText, timestamp), null).toUpperCase();
        return signedText;
    }

    //    /**
    //     * 
    //     * 从服务器获取时间戳
    //     * 
    //     * @param requestURI URI
    //     * @return long
    //     */
    //    private long getServerTimestamp(URI requestURI) {
    //        String uri = requestURI.toString();
    //        int hostIndex = uri.indexOf(requestURI.getHost());
    //        int contextPathBeginIndex = uri.indexOf("/", hostIndex);
    //        int contextPathEndIndex = uri.indexOf("/", contextPathBeginIndex + 1);
    //
    //        String timestampPath = uri.substring(0, contextPathEndIndex) + "/common/server/time/";
    //
    //        Long timestampDiffers = timestampDiffersMap.get(timestampPath);
    //        if (timestampDiffers == null) {
    //            if (log.isDebugEnabled()) {
    //                log.debug("Get Server Timestamp: " + timestampPath);
    //            }
    //
    //            FtcspRestClient ftcspRestClient = new FtcspRestClient(false);
    //            if (ftcspRestClient.get(timestampPath)) {
    //                String timestamp = ftcspRestClient.getResponseContent();
    //                timestampDiffers = System.currentTimeMillis() - Long.valueOf(timestamp);
    //                timestampDiffersMap.put(timestampPath, timestampDiffers);
    //            }
    //        }
    //        return System.currentTimeMillis() - timestampDiffers;
    //    }

    /**
     * 请求数据
     * 
     * @param httpclient CloseableHttpClient
     * @param httpUriRequest HttpUriRequest
     * @return boolean
     */
    private boolean requestData(CloseableHttpClient httpclient, HttpUriRequest httpUriRequest) {
        try {

            if (log.isDebugEnabled()) {
                log.debug("Request Headers: " + headers2Map(httpUriRequest.getAllHeaders()));
            }

            CloseableHttpResponse response = httpclient.execute(httpUriRequest);
            StringBuffer sb = new StringBuffer();

            try {
                if (log.isDebugEnabled()) {
                    log.debug("Response Headers: " + headers2Map(response.getAllHeaders()));
                }

                InputStream in = response.getEntity().getContent();
                InputStreamReader rd = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(rd);

                try {
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        line = br.readLine();
                    }
                } finally {
                    br.close();
                    rd.close();
                }

            } finally {
                response.close();
            }

            responseCode = response.getStatusLine().getStatusCode();
            responseContent = sb.toString();
            if (responseCode == HttpStatus.SC_OK) {
                return true;
            } else {
                log.error("Http request fail, uri: " + httpUriRequest.getURI().toString() + ", status code: " + responseCode
                        + ", response data: " + responseContent);
                return false;
            }
        } catch (ClientProtocolException e1) {
            RuntimeException e = new RuntimeException(e1);
            log.error(e);
            throw e;
        } catch (IOException e2) {
            RuntimeException e = new RuntimeException(e2);
            log.error(e);
            throw e;
        }

    }

    private Map<String, String> headers2Map(Header[] headers) {
        Map<String, String> map = new HashMap<String, String>();

        for (Header header : headers) {
            map.put(header.getName(), header.getValue());
        }

        return map;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
