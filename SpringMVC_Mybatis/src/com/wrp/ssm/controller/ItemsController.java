/**   
*
* 
* 
*/
package com.wrp.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wrp.ssm.controller.validation.ValidGroup1;
import com.wrp.ssm.po.ItemsCustom;
import com.wrp.ssm.po.ItemsQueryVo;
import com.wrp.ssm.service.ItemsService;

/**   
* @Title: ItemsController.java 
* @Description: 商品的Controller
* @author LYleonard
* @date 2016年9月13日 下午10:36:17 
* @version V1.0   
*/

@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	// 商品的分类
	// itemTypes表示最终方法返回值放在request中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes(){
		
		Map<String, String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "电脑");
		
		return itemTypes;
	}
	
	// 商品的查詢
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		// 测试fordward后request是否可一共享
		System.out.println(request.getParameter("id"));
		
		// 調用Servlet查找数据库查询商品
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
//		modelAndView.setViewName("/WEB-INF/views/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	// 商品信息修改页面
	@RequestMapping(value="/editItems", method={RequestMethod.POST,RequestMethod.GET})
	// @RequestParam 中指定request传入参数名称和形参进行绑定。
	// 通过requested属性指定参数是否需要传入,如：@RequestParam(value="id",required=true)
	// 通过defaultValue可以设置默认值，如果id没有传入，则将默认值和形参绑定,如： @RequestParam(value="id", required=true, defaultValue="")
	public String editItems(Model model, @RequestParam(value="id", required=true) Integer items_id) throws Exception {
		
		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
//		if (itemsCustom == null) {
//			throw new CustomException("修改的商品信息不存在");
//		}
		/*// 返回 ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// 商品信息放到model中
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		modelAndView.setViewName("/items/itemsList");*/
		
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}
	
	// 商品信息修改提示
	// 在需要校验的pojo前面添加@Validated注解，在需要校验的pojo的后边添加BindingResult bindingResult参数用来接收校验出错信息
	// 注意：@Validated和BindingResult bindingResult是配对出现的，并且形参的顺序是固定的（一前一后）
	// value={ValidGroup1.class}指定使用ValidGroup1分组进行校验
	// @ModelAttribute("items")可以指定pojo回显到页面在request域中的key。注：@ModelAttribute还可以将方法的返回值传到页面
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request, Integer id, 
			@ModelAttribute("items") @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,
			MultipartFile items_pic // 接收商品图片
			) throws Exception{
		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			/*for(ObjectError objectError:allErrors){
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}*/
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			// 出错则返回到商品的修改页面
			return "items/editItems";
		}
		
		// 上传图片
		// 原始名称
		String originalFilename = items_pic.getOriginalFilename();
		if (items_pic!=null && originalFilename!=null && originalFilename.length()>0) {
			// 存储图片的物理路径
			String pic_path = "F:\\pictures\\upload\\temp\\";
			
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newfile = new File(pic_path+newFileName);
			
			// 将内存中的数据写到磁盘
			items_pic.transferTo(newfile);
			
			// 将新的图片名写到数据库中
			itemsCustom.setPic(newFileName);
		}
		
		// 调用service 更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		
		/*// 返回 ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
		*/
		return "/success";
		
		/*// 重定向到商品查询列表
		return "redirect:queryItems.action";*/
		
		/*// 页面转发
		return "forward:queryItems.action";*/
	}
	
	// 删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		
		// 调用service批量删除商品
		// ....
		
		return "/success";
	}
	
	// 批量修改商品的页面，将商品信息
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		
		// 調用Servlet查找数据库查询商品
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	
	// 批量修改商品的提交
	// 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中的itemsList属性中。
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		
		return "/success";
	}
	
	// 添加商品
	@RequestMapping("/itemsAdd")
	public String itemsAdd(Model model,ItemsQueryVo itemsQueryVo) throws Exception{
		
		Map<String, Object> itemInfo = itemsQueryVo.getItemInfo();
		model.addAttribute("itemInfo", itemInfo);
		
		return "/items/itemsAdd";
	}
	
	@RequestMapping("/itemsAddSubmit")
	public String itemsAddSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		System.out.println(itemsQueryVo.getItemInfo());
		return "/success";
	}
	
	// 查询商品信息，输出json数据
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {
		
		// 调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		return itemsCustom;
		
	}
}
