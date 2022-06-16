package main;

import main.model.Consts;
import main.model.ObjectVO;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        ObjectVO objectVO = new ObjectVO();
        objectVO.setName("NAME a");
        objectVO.setDealType(Consts.DEAL_TYPE_ALL);
        objectVO.setDealName("ALL DEAL NAME");

        objectVO.cleanUp();
        System.out.println(objectVO);

        ObjectVO objectVO1 = new ObjectVO();
        objectVO1.setName("NAME p");
        objectVO1.setDealType(Consts.DEAL_TYPE_PRIMARY);
        objectVO1.setDealName("PRIMARY DEAL NAME ");

        objectVO1.cleanUp();
        System.out.println(objectVO1);

        ObjectVO objectVO2 = new ObjectVO();
        objectVO2.setName("NAME s");
        objectVO2.setDealType(Consts.DEAL_TYPE_SECONDARY);
        objectVO2.setDealName("SECONDARY DEAL NAME");

        objectVO2.cleanUp();
        System.out.println(objectVO2);
    }
}
