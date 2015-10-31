package com.gwm.sweethouse.dao.impl;

import com.gwm.sweethouse.bean.Advice;
import com.gwm.sweethouse.dao.AdviceDao;

public class AdviceDaoImpl extends BaseDao<Advice> implements AdviceDao {

	public void addAdvice(Advice advice) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO advice VALUES (?,?,?,?,?)";
		update(sql,advice.getAdvice_id(),advice.getAdvice_type(),advice.getAdvice_content(),advice.getContact_type(),advice.getUser_id());
	}

}
