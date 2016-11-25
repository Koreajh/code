package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface NotifyMapper {
	 int notifyadd(@Param("notify_from_id")String NOTIFY_FROM_ID, @Param("notify_to_id")String NOTIFY_TO_ID,
			 @Param("notify_con_fst")String NOTIFY_CON_FST, @Param("notify_con_scd")String NOTIFY_CON_SCD, @Param("notify_dt")String NOTIFY_DT);
	 ArrayList<HashMap> notifyview(@Param("notify_to_id")String NOTIFY_TO_ID);
	 
	 int notifystupdate(@Param("notify_from_id")String NOTIFY_FROM_ID, @Param("notify_to_id")String NOTIFY_TO_ID,
			 @Param("notify_con_fst")String NOTIFY_CON_FST);

}
