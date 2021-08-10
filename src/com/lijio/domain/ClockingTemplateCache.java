package com.lijio.domain;

import java.sql.SQLException;
import java.time.LocalTime;

import com.lijio.annotation.ThreadSafe;
import com.lijio.dao.DaoFactory;

/**
 * 默认时间在内存中的缓存

 */
@ThreadSafe
public class ClockingTemplateCache {
    private static ClockingTemplateCache instance;
    public static ClockingTemplateCache getInstance(){
        if(instance==null) {
            synchronized (ClockingTemplateCache.class) {
                if(instance==null) {
                    instance=new ClockingTemplateCache();
                }
            }
        }
        return instance;
    }
    private ClockingTemplate defaultClocking;

    private ClockingTemplateCache(){
        /*默认上班时间*/
        defaultClocking=new ClockingTemplate();
        defaultClocking.setWorkTime(LocalTime.of(9, 00, 00));
        defaultClocking.setNoonBreakTime(LocalTime.of(12, 00,00));
        defaultClocking.setAfternoonWorkTime(LocalTime.of(14, 00,00));
        defaultClocking.setOffWorkTime(LocalTime.of(18, 00, 00));
        defaultClocking.setDefaultClocking(true);
        try {
            DaoFactory.getClockingTemplateDao().insert(defaultClocking);
        } catch (SQLException e) {
        }
    }

    public synchronized void updateDefaultClocking(ClockingTemplate clockingTemplate) throws SQLException{
        defaultClocking.setWorkTime(clockingTemplate.getWorkTime());
        defaultClocking.setNoonBreakTime(clockingTemplate.getNoonBreakTime());
        defaultClocking.setAfternoonWorkTime(clockingTemplate.getAfternoonWorkTime());
        defaultClocking.setOffWorkTime(clockingTemplate.getOffWorkTime());

        if(defaultClocking.getId()==0) {
            DaoFactory.getClockingTemplateDao().insert(defaultClocking);
        }else {
            DaoFactory.getClockingTemplateDao().update(defaultClocking);            
        }
    }

    public synchronized ClockingTemplate getDefaultClocking() {
        return defaultClocking;
    }
}
