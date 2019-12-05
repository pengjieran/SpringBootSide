
package com.examplecn.activiti.config;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.impl.el.FixedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
 * @Description: activiti监听类
 * @author: Aaron
 * @date: 2019年12月5日 下午10:26:00
 */
public class ActProcessListener implements TaskListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ActProcessListener.class);

	private static final long serialVersionUID = -7373646786677699540L;
	
	/**流程监听成员变量*/
	private FixedValue processCode;

	@Override
	public void notify(DelegateTask delegateTask) {
		
		String process = String.valueOf(processCode.getValue(delegateTask));
		logger.info("进入{}流程节点监听.....", process);
		if ("leaveApply".equals(process)) {
			
			delegateTask.addCandidateUser("will");
		} else if ("deptManagerAppr".equals(process)) {
			delegateTask.addCandidateUser("deman");
		} else if ("hrClerkAppr".equals(process)) {
			delegateTask.addCandidateUser("petty");
		} else if ("hrManagerAppr".equals(process)) {
			delegateTask.addCandidateUser("may");
		}

	}

}