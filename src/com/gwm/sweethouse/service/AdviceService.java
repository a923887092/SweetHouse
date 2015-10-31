package com.gwm.sweethouse.service;

import com.gwm.sweethouse.bean.Advice;
import com.gwm.sweethouse.dao.impl.AdviceDaoImpl;

public class AdviceService {
	AdviceDaoImpl adviceDaoImpl = new AdviceDaoImpl();
	public void addAdvice(Advice advice) {
		// TODO Auto-generated method stub
		adviceDaoImpl.addAdvice(advice);
	}

}
