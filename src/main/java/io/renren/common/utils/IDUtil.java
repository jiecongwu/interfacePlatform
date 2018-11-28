/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
package io.renren.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <pre>
 * ID主键工具类。
 * </pre>
 *
 * @author mahuawei@foresee.com.cn
 * @date 2016年12月9日
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录 
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 */
public class IDUtil {

    private static final Logger  logger = LoggerFactory.getLogger(IDUtil.class);


    /**
     * 
     * 获取32位UUID。
     * @return String
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }

}
