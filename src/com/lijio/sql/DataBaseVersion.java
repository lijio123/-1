package com.lijio.sql;

import com.lijio.annotation.NotThreadSafe;

/**
 * 数据库版本
 */
@NotThreadSafe
public enum DataBaseVersion {
    Version_1(1);//版本1
    
    private int versionNum;
    
    private DataBaseVersion(int version) {
        this.versionNum=version;
    }
    
    public int getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(int versionNum) {
        this.versionNum = versionNum;
    }
}
