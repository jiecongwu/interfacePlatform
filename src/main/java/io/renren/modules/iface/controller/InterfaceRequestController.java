package io.renren.modules.iface.controller;
import io.renren.common.utils.DESUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.iface.entity.InterfaceCaseEntity;
import io.renren.modules.iface.entity.InterfaceHeadEntity;
import io.renren.modules.iface.service.InterfaceCaseService;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.commons.collections.MapUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.Gson;
import java.util.List;
import io.renren.common.utils.Jackson;
import io.renren.common.utils.outter.FtcspRestClient;
import io.renren.common.utils.outter.PaySign;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import io.renren.modules.iface.entity.InterfaceCaseRequestEntity;
import io.renren.common.utils.DateUtils;

/**
 * 接口实例表
 *
 * @author wujiecong
 * @email jiecongwu@163.com
 * @date 2018-08-24 16:42:36
 */
@RestController
@RequestMapping("iface/caseexe")
public class InterfaceRequestController {
    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    private static SSLContextBuilder builder = null;
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static final Log log                    = LogFactory.getLog(FtcspRestClient.class);
    private static   HashMap reparam = new HashMap();
    private static boolean status =false;
    private static  String appDesKey ="";

 /*   static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);//max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    /**
     * 列表
     */
    @RequestMapping("/run")
   // @RequiresPermissions("iface:interfacecase:list")
    public HashMap list(@RequestBody InterfaceCaseRequestEntity interfaceCaseRequestEntity) {

        String data ="";
        String url =interfaceCaseRequestEntity.getUrl() ;
        String body= interfaceCaseRequestEntity.getBody();

        //转换当前时间timeStamp
        if (body.indexOf("{timeStamp}")!=-1)
        {log.info("进入replace");
            body=body.replace("{timeStamp}",String.valueOf(System.currentTimeMillis()));

            log.info(body);
        }
        //

       //判断是否加密
         status = interfaceCaseRequestEntity.getUrl().contains("gateway/");
        if(status){


            FtcspRestClient client = new FtcspRestClient("000106", "yu1qoj8kyu1qoj8k", "6ECD141F8B991FB2616214018D9BA32F");
            appDesKey="yu1qoj8kyu1qoj8k";

            Gson gson = new Gson();
            HashMap<String, String> map = new HashMap<String, String>();
            map = gson.fromJson(body, map.getClass());
           //转换传入的time为timestap毫秒
            for(String key : map.keySet()){
                String value = map.get(key) instanceof String?map.get(key):"aaa";

                if(value.indexOf("$")!=-1)
                {

                    Long d=DateUtils.getTimeStamp(value.replace("$", ""));
                    map.put(key,d.toString());
                    body = gson.toJson(map);

                }
            }

                //判断是否要另外的pay_sign加密
            if (body.indexOf("sign")!=-1)
            {

                String signName=map.get("sign") ;

                map.remove("sign");
                //测试环
               String sign=PaySign.genSign(map, "61a9250c107349af9b5135a0677926ee");
                //预生产
               // String sign=PaySign.genSign(map, "048b867114014d009771a01311ef8996");

              //  String sign=PaySign.genSign(map, "b774b3c7b09548378b0d3ec131112eb4");


                map.put(signName, sign);

                 Gson gson1 = new Gson();
                log.info(map);



            }
            body = gson.toJson(map);
            log.info("body");

            log.info(body);

            List urldata = client.post1(url, body);
            url = urldata.get(0).toString();
            if(interfaceCaseRequestEntity.getUrl().contains("/outter/"))
            {   status=true; data = urldata.get(1).toString();
            log.info("data:" + data);
            }
            else { status=false; data=body;}
           }
        else{
            data=body;
            System.out.println(interfaceCaseRequestEntity.getUrl());

        }
        //添加后续的url参数
        url=interfaceCaseRequestEntity.getUrlParam()==null || interfaceCaseRequestEntity.getUrlParam().equals("")?url:url+"&"+interfaceCaseRequestEntity.getUrlParam();
        reparam.put("url",url);
        reparam.put("method",interfaceCaseRequestEntity.getMethod());
        reparam.put("body",body);

        //  client.post("http://tpt.jchl.com/gateway/ordercenter/outter/order/fullRefund", postDataString);
        //  System.out.println(client.getResponseContent());
        CloseableHttpClient httpclient;
        httpclient = HttpClients.custom().build();

        HttpUriRequest httpUriRequest;
        if (true) {
            httpUriRequest = new HttpPost(url);
        } else {
            httpUriRequest = new HttpGet(url);
        }

        // 设置头信息
           if(interfaceCaseRequestEntity.getHead().size()==0)

   {   log.info("添加header");
          httpUriRequest.addHeader("Content-Type", "application/json;charset=UTF-8");
          httpUriRequest.addHeader("Accept", "application/json;charset=UTF-8");
          httpUriRequest.addHeader("Accept-Charset", "UTF-8");


    }
       else {
               for (int i = 0; i < interfaceCaseRequestEntity.getHead().size(); i++) {
                   httpUriRequest.addHeader(interfaceCaseRequestEntity.getHead().get(i).getName(), interfaceCaseRequestEntity.getHead().get(i).getValue());

               }
           }

        // 设置请求数据

        StringEntity stringEntity = new StringEntity(data, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
       // String ContentType =status?"text/json;charset=UTF-8":"application/json";
        //stringEntity.setContentType(ContentType);
        ((HttpPost) httpUriRequest).setEntity(stringEntity);

// 请求数据
        try{
            requestData(httpclient, httpUriRequest);

        }catch (Exception e){
            return R.ok().put("res_data", reparam);

        }

        return R.ok().put("res_data", reparam);



    }

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
            reparam.put("requestHeaders",httpUriRequest.getAllHeaders());

            CloseableHttpResponse response = httpclient.execute(httpUriRequest);
         //   System.out.println("wjc:"+readHttpResponse(response)) ;
            StringBuffer sb = new StringBuffer();
            try {
                if (log.isDebugEnabled()) {
                    log.debug("Response Headers: " + headers2Map(response.getAllHeaders()));
                }
                reparam.put("responseHeaders",response.getAllHeaders());

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

         int   responseCode = response.getStatusLine().getStatusCode();
            String  responseContent = "";
            reparam.put("responseCode",responseCode);

            if (status){

                    try {
                        log.debug("sb.toString(): " + sb.toString());
                        responseContent = DESUtil.decrypt(sb.toString(), appDesKey, true);
                        log.info(" response data: " + responseContent);
                        reparam.put("responseContent",responseContent);

                    } catch (Exception e1) {
                        RuntimeException e = new RuntimeException(e1);
                        log.error(e);
                        reparam.put("responseContent",e);
                        // throw e;
                    }

            }else{
                  responseContent = sb.toString();
                  reparam.put("responseContent",sb.toString());

            }
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
            reparam.put("responseContent",e.getMessage());
            throw e;

        }

    }
    //读取请求响应
    public static String readHttpResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
        StringBuilder builder = new StringBuilder();
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        builder.append("status:" + httpResponse.getStatusLine());
        builder.append("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            builder.append("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            builder.append("response length:" + responseString.length());
            builder.append("response content:" + responseString.replace("\r\n", ""));
        }
        return builder.toString();
    }
//
private Map<String, String> headers2Map(Header[] headers) {
    Map<String, String> map = new HashMap<String, String>();

    for (Header header : headers) {
        map.put(header.getName(), header.getValue());
    }

    return map;
}


}
