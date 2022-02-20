package com.example.Raiffeisen.service;

import com.example.Raiffeisen.controller.SocksController;
import com.example.Raiffeisen.model.Socks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.Raiffeisen.repository.SocksRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SocksService {
    private final SocksRepository socksRepository;
    private static final Logger log = LoggerFactory.getLogger(SocksController.class);
    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }
    @Transactional
    public long getPairsSocks(String color, String operation, int cottonPart){
        long countSocks=0;
        Operation operation1;
        switch (operation.toLowerCase()){
            case "morethan":
                operation1 = (int x, int y)-> x>y;
                break;
            case "lessthan":
                operation1 = (int x, int y)-> x<y;
                break;
            case "equal":
                operation1 = (int x, int y)-> x==y;
                break;

            default:
                throw new IllegalStateException("Unexpected operation value: " + operation.toLowerCase());
        }
        List<Socks> socksRepositoryAll= (List<Socks>) socksRepository.findAll();
        for (Socks socks: socksRepositoryAll) {
            if ((socks.getColor().equalsIgnoreCase(color))&&(operation1.compare(socks.getCottonPart(),cottonPart))){
                countSocks+=socks.getQuantityPairs();
            }
        }
        return countSocks;
    }
    @Transactional
    public void addSocks(String color, int cottonPart, int quantity) {
        boolean isAdd=false;
        List<Socks> socksRepositoryAll= (List<Socks>) socksRepository.findAll();
        if (socksRepositoryAll.size()==0){
            Socks addedSocks= new Socks(color,cottonPart,quantity);
            socksRepository.save(addedSocks);
            isAdd=true;
        }
        for (Socks socks: socksRepositoryAll) {
            if ((socks.getColor().equalsIgnoreCase(color))&&(socks.getCottonPart()==cottonPart)){
                socks.setQuantityPairs(socks.getQuantityPairs()+quantity);
                socksRepository.save(socks);
                isAdd=true;
                break;
            }
        }
        if (!isAdd){
            Socks incomeSocks= new Socks(color,cottonPart,quantity);
            socksRepository.save(incomeSocks);
        }

    }
    @Transactional
    public void outcomeSocks(String color, int cottonPart, int quantity){
        List<Socks> socksRepositoryAll= (List<Socks>) socksRepository.findAll();
        for (Socks socks: socksRepositoryAll) {
            if ((socks.getColor().equalsIgnoreCase(color))&&(socks.getCottonPart()==cottonPart)&&(socks.getQuantityPairs()>=quantity)){
                    socks.setQuantityPairs(socks.getQuantityPairs()-quantity);
                    socksRepository.save(socks);
                    break;
            }
        }
    }
    interface Operation{
        boolean compare(int x, int y);
    }
}
