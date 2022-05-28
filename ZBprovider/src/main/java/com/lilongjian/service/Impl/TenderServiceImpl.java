package com.lilongjian.service.Impl;

import com.lilongjian.dao.TenderMapper;
import com.lilongjian.domain.Tender;
import com.lilongjian.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TenderServiceImpl implements TenderService {
    @Autowired
    private TenderMapper tenderMapper;

    @Override
    public Tender getTenderById(int id) {
        return tenderMapper.getTenderById(id);
    }

    @Override
    public Tender getTenderByNumber(String number) {
        return tenderMapper.getTenderByNumber(number);
    }

    @Override
    public List<Tender> getTendersByAnnouncer(String email) {
        return tenderMapper.getTendersByAnnouncer(email);
    }

    @Override
    public Tender setTenderStatus(String number,int status) {
        if (number == null) return null;
        HashMap<String,Object> map = new HashMap<>();
        map.put("number", number);
        map.put("status", status);
        int i = tenderMapper.setTenderStatus(map);
        if(i>0) {
           return tenderMapper.getTenderByNumber(number);
        }
        return null;
    }

    @Override
    public Tender setStatusById(int id,int status) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        int i = tenderMapper.setStatusById(map);
        if(i>0) {
            return tenderMapper.getTenderById(id);
        }
        return null;

    }

    @Override
    public Tender update(Tender tender) {
        if (tender == null) return null;
        int i = tenderMapper.update(tender);
        Tender tender1 = null;
        if (i > 0) {
            tender1 = tenderMapper.getTenderByNumber(tender.getNumber());
        }
        return tender1;
    }

    @Override
    public int deleteByNumber(String number) {
        if (number == null) return -1;
        return tenderMapper.deleteByNumber(number);
    }

    @Override
    public int deleteById(int id) {

        return tenderMapper.deleteById(id);
    }

    @Override
    public Tender addNewTender(Tender tender) {
        if (tender == null) return null;


        String s = UUID.randomUUID().toString().replace("-", "");
        String number = "ZB-" + s;//产生唯一的招标编号
        tender.setNumber(number);
        tender.setDate(new Date());
        int i = tenderMapper.addNewTender(tender);
        if (i > 0) return tenderMapper.getTenderByNumber(number);
        return null;
    }

    @Override
    public List<Tender> getAllTenders() {
        return tenderMapper.getAllTenders();
    }
}
