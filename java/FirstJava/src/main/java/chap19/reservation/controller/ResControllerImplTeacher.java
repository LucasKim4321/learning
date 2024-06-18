package chap19.res.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseController;
import chap19.res.dao.ResDAO;
import chap19.res.dao.ResDAOImpl;
import chap19.res.vo.ResVO;

public class ResControllerImpl extends AbstractBaseController implements ResController{

	private ResDAO resDAO;
	
	public ResControllerImpl() {
		resDAO = new ResDAOImpl();
	}
	
	@Override
	public List<ResVO> listResInfo(ResVO resVO) {
		List<ResVO> resList = new ArrayList<ResVO>();
		try {
			resList = resDAO.selectResInfo(resVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resList;
	}

	@Override
	public int regResInfo(ResVO resVO) {
		int result = 0;
		try {
			result = resDAO.insertResInfo(resVO);
		} catch (Exception e) {System.out.println(e.getMessage());}
		return result;
	}

	@Override
	public int modResInfo(ResVO resVO) {
		int result = 0;
		try {
			result = resDAO.updateResInfo(resVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int cancelResInfo(ResVO resVO) {
		int result = 0;
		try {
			result = resDAO.deleteResInfo(resVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}