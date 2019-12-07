		var setting = {
			callback: {
				onClick: zTreeOnClick
			},
			view:{
			    showLine:false
			},
			data: {
				key: {
					title:"t"
				},
			simpleData: {
				enable: true
				}
			}
		};

		var zNodes1 = [
			{id:1, pId:0, name:"设备视图", open:false,icon:"/static/images/icon30.gif"},
			{id:1011, pId:1, name:"设备负荷报告",icon:"/static/images/icon18.gif"},
			{id:1012, pId:1, name:"设备状态报告",icon:"/static/images/icon18.gif"},
			{id:103, pId:1, name:"设备故障报告",icon:"/static/images/icon18.gif"},

			{id:2, pId:0, name:"项目视图", open:false,icon:"/static/images/icon76.gif"},
			{id:201, pId:2, name:"项目状态视图",icon:"/static/images/icon18.gif"},
			          	
			{id:3, pId:0, name:"试验视图", open:false,icon:"/static/images/trialView.png"},
			{id:301, pId:3, name:" 试验状态视图",icon:"/static/images/icon18.gif"},
			          		
			{id:4, pId:0, name:"管理视图", open:false,icon:"/static/images/guanlishitu.gif"},
			{id:401, pId:4, name:"组织架构视图",icon:"/static/images/icon18.gif"},
			{id:402, pId:4, name:"知识分布视图",icon:"/static/images/icon18.gif"},
			          		
			{id:5, pId:0, name:"耗材视图", open:false,icon:"/static/images/designer_16.gif"},
			{id:501, pId:5, name:"耗材使用报告",icon:"/static/images/icon18.gif"},
			          	
			{id:6, pId:0, name:"资源排程", open:false,icon:"/static/images/bill.png"},
			{id:601, pId:6, name:"人员排程",icon:"/static/images/icon18.gif"},
			{id:602, pId:6, name:"设备排程",icon:"/static/images/icon18.gif"}
		];
			    var zNodes2 = [
					{id:1, pId:0, name:"委托书管理", open:false,icon:"/static/images/icon41.gif"},
					{id:101, pId:1, name:"委托书管理", file:"core/standardData",icon:"/static/images/icon18.gif"},
					{id:102, pId:1, name:"委托书发起", file:"core/simpleData",icon:"/static/images/icon18.gif"},
					{id:103, pId:1, name:"已受理的委托书", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:104, pId:1, name:"多维度查询", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:105, pId:1, name:"高级查询", file:"core/noline",icon:"/static/images/icon18.gif"},

					{id:2, pId:0, name:"项目维度", open:false,icon:"/static/images/outlook2.gif"},
					{id:201, pId:2, name:"新建项目", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:202, pId:2, name:"多维度查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:203, pId:2, name:"高级查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:3, pId:0, name:"试验维度", open:false,icon:"/static/images/frametree01.gif"},
					{id:301, pId:3, name:"新建实验", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:302, pId:3, name:"多维度查询", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:303, pId:3, name:"高级查询", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					
					{id:4, pId:0, name:"数据维度", open:false,icon:"/static/images/icon71.gif"},
					{id:401, pId:4, name:"新建项目", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:402, pId:4, name:"多维度查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:403, pId:4, name:"高级查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:5, pId:0, name:"检测类型管理", open:false,icon:"/static/images/inspection_16.png"},
					{id:501, pId:5, name:"检测类型管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:502, pId:5, name:"试验标准管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:503, pId:5, name:"试验方法管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:504, pId:5, name:"实验标准分类设置", file:"super/oneroot",icon:"/static/images/icon18.gif"},
				
					{id:6, pId:0, name:"外场应用", open:false,icon:"/static/images/mobile.png"},
					{id:601, pId:6, name:"离线导出", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:602, pId:6, name:"离线导入", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:603, pId:6, name:"移动导出", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:604, pId:6, name:"移动导入", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:7, pId:0, name:"分布式应用", open:false,icon:"/static/images/share.png"},
					{id:701, pId:7, name:"数据共享", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:702, pId:7, name:"数据同步", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:8, pId:0, name:"管理要求", open:false,icon:"/static/images/manageVIew.png"},
					{id:801, pId:8, name:"不符合项管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:802, pId:8, name:"纠正措施", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:803, pId:8, name:"改进措施", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:804, pId:8, name:"预防措施", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:805, pId:8, name:"内审管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:806, pId:8, name:"管理评审", file:"exhide/checkbox",icon:"/static/images/icon18.gif"}
				];
				var zNodes3 = [
					{id:1, pId:0, name:"文档管理", open:false,icon:"/static/images/doc.gif"},
					{id:101, pId:1, name:"新建文档", file:"core/standardData",icon:"/static/images/icon18.gif"},
					{id:102, pId:1, name:"多维度查询", file:"core/simpleData",icon:"/static/images/icon18.gif"},
					{id:103, pId:1, name:"高级查询", file:"core/noline",icon:"/static/images/icon18.gif"},

					{id:2, pId:0, name:"设备管理", open:false,icon:"/static/images/icon30.gif"},
					{id:201, pId:2, name:"新建设备", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:202, pId:2, name:"多维度查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:203, pId:2, name:"高级查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:204, pId:2, name:"采购管理", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:205, pId:2, name:"设备预约单查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:206, pId:2, name:"设备使用记录", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:3, pId:0, name:"样品管理", open:false,icon:"/static/images/configure.gif"},
					{id:301, pId:3, name:"样品接收登记", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:302, pId:3, name:"多维度查询", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:303, pId:3, name:"高级查询", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					
					{id:4, pId:0, name:"耗材管理", open:false,icon:"/static/images/designer_16.gif"},
					{id:401, pId:4, name:"新建耗材", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:402, pId:4, name:"高级查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:403, pId:4, name:"耗材预约单查询", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:5, pId:0, name:"设施管理", open:false,icon:"/static/images/facilities.gif"},
					{id:501, pId:5, name:"新建设施", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:502, pId:5, name:"高级查询", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:503, pId:5, name:"设施管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
				
					{id:6, pId:0, name:"实验室中心", open:false,icon:"/static/images/labView.png"},
					{id:601, pId:6, name:"实验室管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:602, pId:6, name:"实验室看板", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:7, pId:0, name:"知识库中心", open:false,icon:"/static/images/konwlageView.png"},
					{id:701, pId:7, name:"知识库", file:"exhide/common",icon:"/static/images/icon18.gif"},
					
					{id:8, pId:0, name:"全文检索", open:false,icon:"/static/images/icon06.gif"},
					{id:8801, pId:8, name:"全文检测", file:"exhide/common",icon:"/static/images/icon18.gif"}
				];
				var zNodes4 = [
					{id:1, pId:0, name:"个人中心", open:false,icon:"/static/images/create.png"},
					{id:101, pId:1, name:"我的待办", file:"core/standardData",icon:"/static/images/icon18.gif"},
					{id:102, pId:1, name:"我的委托书", file:"core/simpleData",icon:"/static/images/icon18.gif"},
					{id:103, pId:1, name:"我的订阅", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:104, pId:1, name:"我的文档", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:105, pId:1, name:"我的项目", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:106, pId:1, name:"我的实验", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:107, pId:1, name:"我的数据", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:108, pId:1, name:"我的设备", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:109, pId:1, name:"我的样品", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:110, pId:1, name:"我的流程", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:111, pId:1, name:"我的报表", file:"core/noline",icon:"/static/images/icon18.gif"},
					{id:112, pId:1, name:"个人设置", file:"core/noline",icon:"/static/images/icon18.gif"}
				];
				var zNodes5 = [
					{id:1, pId:0, name:"文档设置", open:false,icon:"/static/images/doc.gif"},
					{id:101, pId:1, name:"文档目录设置", file:"core/standardData",icon:"/static/images/icon18.gif"},
					{id:102, pId:1, name:"文档管理", file:"core/simpleData",icon:"/static/images/icon18.gif"},

					{id:2, pId:0, name:"项目设置", open:false,icon:"/static/images/outlook2.gif"},
					{id:201, pId:2, name:"项目分类设置", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:202, pId:2, name:"项目模板设置", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:203, pId:2, name:"项目管理", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:3, pId:0, name:"试验设置", open:false,icon:"/static/images/frametree01.gif"},
					{id:301, pId:3, name:"实验分类管理", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:302, pId:3, name:"试验模板设置", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:303, pId:3, name:"试验管理", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:304, pId:3, name:"交接班管理", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					{id:305, pId:3, name:"交接班高级查询", file:"exedit/drag",icon:"/static/images/icon18.gif"},
					

					{id:4, pId:0, name:"数据设置", open:false,icon:"/static/images/icon71.gif"},
					{id:401, pId:4, name:"数据分类设置", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:402, pId:4, name:"数据模板设置", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:403, pId:4, name:"教采方案设置", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
					{id:404, pId:4, name:"数据管理", file:"excheck/checkbox",icon:"/static/images/icon18.gif"},
				
					{id:5, pId:0, name:"设备设置", open:false,icon:"/static/images/icon30.gif"},
					{id:501, pId:5, name:"设备分类设置", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:502, pId:5, name:"设备管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
					{id:503, pId:5, name:"故障管理", file:"super/oneroot",icon:"/static/images/icon18.gif"},
				
					{id:6, pId:0, name:"样品/耗材设置", open:false,icon:"/static/images/configure.gif"},
					{id:601, pId:6, name:"样品分类设置", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:602, pId:6, name:"样品管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:603, pId:6, name:"耗材管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:604, pId:6, name:"产品管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:7, pId:0, name:"客户/供应商设置", open:false,icon:"/static/images/icon67.gif"},
					{id:701, pId:7, name:"客户管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:702, pId:7, name:"客户查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:703, pId:7, name:"供应商管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:704, pId:7, name:"供应商查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:8, pId:0, name:"流程/表单设置", open:false,icon:"/static/images/outlook8.gif"},
					{id:801, pId:8, name:"流程定义", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:802, pId:8, name:"流程查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:803, pId:8, name:"流程运行监控", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:804, pId:8, name:"表单定义", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:805, pId:8, name:"表单查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:806, pId:8, name:"管理评审", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},


					{id:9, pId:0, name:"报表/报告设置", open:false,icon:"/static/images/icon66.gif"},
					{id:901, pId:9, name:"报表管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:902, pId:9, name:"报表查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:903, pId:9, name:"报告模板管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:904, pId:9, name:"报告管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:905, pId:9, name:"试验报告管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:906, pId:9, name:"试验方案查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:10, pId:0, name:"环境参数控制", open:false,icon:"/static/images/profile_obj.gif"},
					{id:1001, pId:10, name:"环境参数控制", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1002, pId:10, name:"高级查询", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:11, pId:0, name:"系统字典设置", open:false,icon:"/static/images/outlook7.gif"},
					{id:1101, pId:11, name:"试验阶段", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1102, pId:11, name:"试验专业", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1103, pId:11, name:"试验结果", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1104, pId:11, name:"试验地点", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1105, pId:11, name:"故障类型", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1106, pId:11, name:"样品状态", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:12, pId:0, name:"系统组织架构设置", open:false,icon:"/static/images/icon56.gif"},
					{id:1201, pId:12, name:"用户管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1202, pId:12, name:"部门管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1203, pId:12, name:"角色管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1204, pId:12, name:"职务管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1205, pId:12, name:"学历管理", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1206, pId:12, name:"待遇管理", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:13, pId:0, name:"系统参数设置", open:false,icon:"/static/images/icon15.gif"},
					{id:1301, pId:13, name:"菜单设置", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1302, pId:13, name:"主题设置", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1303, pId:13, name:"门户设置", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1304, pId:13, name:"状态设置", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1305, pId:13, name:"密级设置", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1306, pId:13, name:"安全设置", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1307, pId:13, name:"检索设置", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1308, pId:13, name:"任务预警设置", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:14, pId:0, name:"系统备份/恢复", open:false,icon:"/static/images/repository-synchronize.gif"},
					{id:1401, pId:14, name:"自动备份", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1402, pId:14, name:"手动备份", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1403, pId:14, name:"系统恢复", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:15, pId:0, name:"系统在线管理", open:false,icon:"/static/images/icon54.gif"},
					{id:1501, pId:15, name:"在线用户", file:"exhide/common",icon:"/static/images/icon18.gif"},
					{id:1502, pId:15, name:"解锁用户", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					{id:1503, pId:15, name:"系统日志", file:"exhide/checkbox",icon:"/static/images/icon18.gif"},
					
					{id:16, pId:0, name:"关于系统", open:false,icon:"/static/images/frametree03.gif"},
					{id:1601, pId:16, name:"关于系统", file:"exhide/common",icon:"/static/v/icon18.gif"}
					]
			    
					$(document).ready(function(){
						$.fn.zTree.init($("#jc"), setting, zNodes1);
						$.fn.zTree.init($("#yw"), setting, zNodes2);
						$.fn.zTree.init($("#zy"), setting, zNodes3);
						$.fn.zTree.init($("#gr"), setting, zNodes4);
						$.fn.zTree.init($("#xt"), setting, zNodes5);
					});
				//ztree的点击事件 创建标签页
				function zTreeOnClick(event, treeId, treeNode) {
					var StaticTreeid=treeNode.id;
					if(StaticTreeid==101){
						createTab("proxyID","委托书管理","/jsps/proxy/manageProxy.jsp",true);
					}
					if(StaticTreeid==102){
						createTab("myproxy","委托书发起","/jsps/proxy/myProxy.jsp",true);
					}
					if(StaticTreeid==1011){
						createTab("eqmLoad","设备负荷报告","/jsps/device/eqmLoad.jsp",true);
					}
					if(StaticTreeid==1012){
						createTab("eqmState","设备状态报告","/jsps/eqmStates/eqmState.jsp",true);
					}
					if(StaticTreeid==8801){
						createTab("search","全文检索","/jsps/searcher/searchPage.jsp",true);
					}
					if(StaticTreeid==301){
                        getAllProxy();
					}
					if(StaticTreeid==303){
                        createTab("equipment","高级查询","/jsps/experiment/selectExperiment.jsp",true);
					}
					if(StaticTreeid==205){
                        createTab("orderEqm","设备预约单查询","/jsps/experiment/orderExperiment.jsp",true);
					}

					
				}
				function createTab(id,name,url,isClose){
				 	closableTab.addTab({'id': id, 'name': name, 'url': url, 'closable': isClose});
				}
				//初始化所有委托书table，并展示模态框
				function getAllProxy() {
                    initAllProxyTable();
                    $("#allProxyModal").modal("show");
                }
