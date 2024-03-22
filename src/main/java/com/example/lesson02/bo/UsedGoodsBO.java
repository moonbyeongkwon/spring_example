package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service
public class UsedGoodsBO {

	@Autowired // Dependency Injection(DI) 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // spring bean을 가져온다.
	
	// input: Controller로부터 받아온다
	// output: Controller한테 준다.
	public List<UsedGoods> getUsedGoodsList() {
		
		return usedGoodsMapper.selectUsedGoodsList(); 
	}
}
