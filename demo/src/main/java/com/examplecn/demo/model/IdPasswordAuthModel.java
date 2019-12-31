/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/31 16:27
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.model;

import lombok.Data;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/31 16:27
 */
@Data
public class IdPasswordAuthModel extends AuthModel {

    private static final long serialVersionUID = -5347656325432534L;

    private String password;
}
