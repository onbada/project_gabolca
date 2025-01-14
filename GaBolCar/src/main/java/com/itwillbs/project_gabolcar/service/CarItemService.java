package com.itwillbs.project_gabolcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itwillbs.project_gabolcar.mapper.BrcMapper;
import com.itwillbs.project_gabolcar.mapper.CarMapper;

import com.itwillbs.project_gabolcar.mapper.*;
import com.itwillbs.project_gabolcar.vo.*;



@Service
public class CarItemService {
	@Autowired
	BrcMapper brcMapper;
	
	@Autowired
	CarItemMapper carItemMapper;
	
	@Autowired
	CarMapper carMapper;
	
	@Autowired
	ResMapper resMapper;
	
	// db 에서 지점 찾기
	public List<String> findBrcList(){
		// 변수 초기화
		List<String> brcList = new ArrayList<String>();
		List<Map<String, Object>> brcMapList = null;
		
		brcMapList = brcMapper.selectBrcList();
		if(brcMapList != null) {
			for(Map<String, Object> map : brcMapList) {
				brcList.add(map.get("brc_name").toString());
			} // for 문 끝
		}// if 문 끝
		return brcList;
	} // findBrcList 끝
	
	// ========== 차량 인기 순위 리스트 ============
	public List<Map<String,Object>> getCarPopuler(){
		
		return resMapper.selectResPopuler();
	}
	
	
	// 최대 페이지 등 페이지 관련에쓸 차량 총 댓수
	public int getCarCount() {
		return carMapper.selectCarListCount();
	}
	//==============================================
	
	public List<Integer> getCarIndexList(){
		return carMapper.selectCarIdxList();
	}
	
//==============리뷰 서비스=============================
	public List<ReviewVO> getReviewList(){
		
		return carItemMapper.selectReviewList();
	}
	//==========getReviewList() 끝=======
	
// ============ 차량 소개 ==================================
	public List<Map<String, Object>> carInfoList() {
		return carItemMapper.selectCarInfoList();
	}
}


