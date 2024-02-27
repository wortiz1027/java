package org.workshop.starter.objects;

public enum Algorithm {

    BCRYPT("bcrypt"),
    MD5("md5");

    private String name;

    Algorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Algorithm getEnumByString(String code){
        for(Algorithm e : Algorithm.values()){
            if(e.name.equals(code)) return e;
        }
        return null;
    }

}