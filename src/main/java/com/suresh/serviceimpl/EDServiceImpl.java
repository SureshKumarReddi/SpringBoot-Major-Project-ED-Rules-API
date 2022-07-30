package com.suresh.serviceimpl;

import org.springframework.stereotype.Service;

import com.suresh.bindings.CitizenData;
import com.suresh.bindings.PlanInfo;
import com.suresh.service.EDService;

@Service
public class EDServiceImpl implements EDService {

	@Override
	public PlanInfo getPlanInfo(CitizenData data) {

		PlanInfo planInfo = new PlanInfo();

		String planName = data.getPlanName().toLowerCase();

		if ("snap".equals(planName)) {
			if (data.getIncome() == 0 || data.getIncome() <= 200)
			planInfo.setCitizenId(data.getCitizenId());
			planInfo.setPlanName(data.getPlanName());
			planInfo.setMessage("You have Eligibility for " + data.getPlanName());
		 

		} else if ("ccap".equals(planName)) {
			if(data.getIncome() <= 200 &&  data.isChildern()) {
				if(data.getAge()<=16) {
					planInfo.setCitizenId(data.getCitizenId());
					planInfo.setPlanName(data.getPlanName());
					planInfo.setMessage("You have Eligibility for " + data.getPlanName());
				}
			}

		} else if ("medicaid".equals(planName) && data.getIncome()<=300) {
			planInfo.setCitizenId(data.getCitizenId());
			planInfo.setPlanName(data.getPlanName());
			planInfo.setMessage("You have Eligibility for " + data.getPlanName());

		} else if ("medicare".equals(planName)&& data.getAge()>=65) {
			planInfo.setCitizenId(data.getCitizenId());
			planInfo.setPlanName(data.getPlanName());
			planInfo.setMessage("You have Eligibility for " + data.getPlanName());

		} else if ("kw".equals(planName) && !data.isWorkStatus()) {
			planInfo.setCitizenId(data.getCitizenId());
			planInfo.setPlanName(data.getPlanName());
			planInfo.setMessage("You have Eligibility for " + data.getPlanName());
		}
		return planInfo;

	}

}
