/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/30 19:31
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.utils;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/30 19:31
 */
public enum CacheType {

    /**
     * 不可清理的缓存
     */
    INERASABLE(-1),

    /**
     * 可被清理的缓存
     */
    ERASABLE(2 * 60 * 60);

    private long defaultExpire;//默认时间（秒）


    CacheType(long defaultExpire) {
        this.defaultExpire = defaultExpire;
    }


    public long getDefaultExpire() {
        return defaultExpire;
    }
}
