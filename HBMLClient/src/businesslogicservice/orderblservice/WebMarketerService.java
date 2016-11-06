package businesslogicservice.orderblservice;

import vo.AppealVO;

public interface WebMarketerService {
	public void checkAppealReason(AppealVO appeal);
	public void showAppealList(AppealVO[] appealItem);
	public boolean saveAppealResultReason(AppealVO[] appealItem);
}
