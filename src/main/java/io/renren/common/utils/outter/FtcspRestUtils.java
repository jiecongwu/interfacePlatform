/**
 * Copyright(c) Foresee Science & Technology Ltd. 
 */
/**
 * 
 */
package io.renren.common.utils.outter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * REST接口工具类
 * </pre>
 *
 * @author chenqiang@foresee.com.cn
 * @date 2017年6月7日
 * @version 1.00.00
 */
public class FtcspRestUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(FtcspRestUtils.class);
    
    private FtcspRestUtils() {
        
    }

    public static HttpServletRequest getRequest() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
        return null;
    }

    public static Object getAttribute(String name, Object defaultValue) {
        if (getRequest() == null) {
            return defaultValue;
        }
        Object attribute = getRequest().getAttribute(name);
        if (attribute != null) {
            return attribute;
        }
        return defaultValue;
    }
    
    /**
     * 根据环境变量重新设置接口URL中网关（可能没有网关）及服务的名称。 一般是加上开发者名称，实现在开发环境中调试本地服务。
     * @param url 配置的接口URL
     * @return String 实际的接口URL
     */
    public static String resolveURL(String url, boolean external) {
        url = url.substring("http://".length());
        String[] urlParts = url.split("/");

        int gatewayIndex = -1;
        int serviceIndex = -1;

        // 处理网关服务
        if (external) {
            gatewayIndex = 1;
            serviceIndex = 2;
        } else if (urlParts[0].equals("gateway") || urlParts[0].equals("foresee-gateway-server")) {
            gatewayIndex = 0;
            serviceIndex = 1;
        } else {
            serviceIndex = 0;
        }

        if (gatewayIndex >= 0) {
            String gatewayNameEnv = getEnv("FTCSP_ENV_" + urlParts[gatewayIndex]);
            if (StringUtils.isNotBlank(gatewayNameEnv)) {
                urlParts[gatewayIndex] = gatewayNameEnv;
            }
        }

        String serviceNameEnv = getEnv("FTCSP_ENV_" + urlParts[serviceIndex]);
        if (StringUtils.isNotBlank(serviceNameEnv)) {
            urlParts[serviceIndex] = serviceNameEnv;
        }

        StringBuffer sb = new StringBuffer("http:/");
        for (String part : urlParts) {
            sb.append("/").append(part);
        }
        
        String newUrl = sb.toString();
        if (!url.equals(newUrl)) {
            logger.debug("Resolve url [{}] to [{}].", url, newUrl);
        }
        
        return newUrl;
    }

    /**
     * 获取环境变量
     * 
     * @param name 环境变量名称
     * @return String 环境变量值
     */
    private static String getEnv(String name) {
        name = name.replace('-', '_');
        String value = System.getProperty(name);
        if (StringUtils.isBlank(value)) {
            value = System.getenv(name);
        }

        return value;
    }
}
