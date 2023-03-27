package EazyRooM.EazyController;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import EazyRooM.dao.EazyRooMDao;
import EazyRooM.entities.Eazy;

@Controller
public class App
{
	@Autowired
	private EazyRooMDao eazyRooMDao;
	
	@RequestMapping("/home")
	public String  home() 
	{
		return "index";
	}
	@RequestMapping("/tenant")
	public String  tenant() 
	{
		return "tenant";
	}
	@RequestMapping("/owner")
	public String  owner() 
	{
		return "owner";
	}
	@RequestMapping("/tenantadd")
	public String  tenantadd() 
	{
		return "tenantadd";
	}
	@RequestMapping("/owneradd")
	public String  owneradd() 
	{
		return "owneradd";
	}
	@RequestMapping("/tenantdelete")
	public String  tenantdelete() 
	{
		return "tenantdelete";
	}
	@RequestMapping("/ownerdelete")
	public String  ownerdelete() 
	{
		return "ownerdelete";
	}
	@RequestMapping("/postdeletetenant")
	public String postdeletetenant(@RequestParam("contno") long contno,@RequestParam("pswd") int pswd,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMDao.seeyourpost(contno,pswd,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid Contact Number and Password...!");
			return "tenantdelete";
		}
		m.addAttribute("eazy",eazy);
		return "postdeletetenant";
	}
	@RequestMapping("/postdeleteown")
	public String postdeleteown(@RequestParam("contno") long contno,@RequestParam("pswd") int pswd,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMDao.seeyourpost(contno,pswd,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid Contact Number and Password...!");
			return "ownerdelete";
		}
		m.addAttribute("eazy",eazy);
		return "postdeleteown";	
	}
	@RequestMapping("/seeallowner")
	public String  seeallowner() 
	{
		return "seeallowner";
	}
	@RequestMapping("/seealltenant")
	public String  seealltenant() 
	{
		return "seealltenant";
	}
	@RequestMapping("/seetenant")
	public String  seetenant(@RequestParam("city") String city,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMDao.getUserByCity(city,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid City...!");
			return "seealltenant";
		}
		m.addAttribute("eazy",eazy);
		m.addAttribute("city",city);
		return "seetenant";
	}
	
	@RequestMapping("/seetenantgender")
	public String  seetenant(@RequestParam("city") String city,@RequestParam("utype") String utype,@RequestParam("gender") String gender,Model m) 
	{
		List<Eazy> eazy =eazyRooMDao.getUserByCitygender(city,utype,gender);
		if(eazy.isEmpty())
		{
			return "seealltenant";
		}
		m.addAttribute("eazy",eazy);
		return "seetenantgender";
	}
	
	@RequestMapping("/seeowner")
	public String  seeowner(@RequestParam("city") String city,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMDao.getUserByCity(city,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid City...!");
			return "seeallowner";
		}
		m.addAttribute("eazy",eazy);
		return "seeowner";
	}
	@RequestMapping("/donetenant")
	public String donetenant(@ModelAttribute Eazy eazy,Model m)
	{
		List<Eazy> emp=eazyRooMDao.getUsercount(eazy.getContno());
		if(emp.size()>0)
		{
			m.addAttribute("msg","Invalid data");
			return "tenantadd";
		}
		eazyRooMDao.CreateAcnt(eazy);	
		return "donetenant";	
	}
	@RequestMapping("/doneowner")
	public String doneowner(@ModelAttribute Eazy eazy,Model m)
	{
		List<Eazy> emp=eazyRooMDao.getUsercount(eazy.getContno());
		if(emp.size()>0)
		{
			m.addAttribute("msg","Invalid data");
			return "owneradd";
		}
		eazyRooMDao.CreateAcnt(eazy);	
		return "doneowner";	
	}
	@RequestMapping("/deletetenant/{eazyId}")
	public RedirectView deletetenant(@PathVariable("eazyId") int eazyId,HttpServletRequest request) 
	{
		this.eazyRooMDao.deleteEazy(eazyId);
		Eazy eazy=eazyRooMDao.getEazy(eazyId);
		if(eazy!=null)
		{
			System.out.println("Account Deleted ID."+eazyId);
		}
		else
		{
			System.out.println("Account Deleted ID"+eazyId);
		}
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/tenantdelete");
		return redirectView;	
	}
	@RequestMapping("/deleteown/{eazyId}")
	public RedirectView deleteown(@PathVariable("eazyId") int eazyId,HttpServletRequest request) 
	{
		this.eazyRooMDao.deleteEazy(eazyId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/ownerdelete");
		return redirectView;	
	}
	
	@RequestMapping("/updateown/{eid}")
	public String updateForm1(@PathVariable("eid") int eid,Model m) 
	{
		Eazy eazy = this.eazyRooMDao.getEazy(eid);
		m.addAttribute(eazy);
		return "updateown";		
	}
	
	@RequestMapping("/updatetenant/{eid}")
	public String updateForm2(@PathVariable("eid") int eid,Model m) 
	{
		Eazy eazy = this.eazyRooMDao.getEazy(eid);
		m.addAttribute(eazy);
		return "updatetenant";		
	}
}
