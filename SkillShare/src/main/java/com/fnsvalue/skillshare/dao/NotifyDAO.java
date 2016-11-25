package com.fnsvalue.skillshare.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface NotifyDAO {
	public int notifyadd(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST, String NOTIFY_CON_SCD, String NOTIFY_DT);
	public ArrayList<HashMap> notifyview(String NOTIFY_TO_ID);
	public int notifystupdate(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST);

}
