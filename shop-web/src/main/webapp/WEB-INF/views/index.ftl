<!DOCTYPE html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link href="${ctx}/favicon.ico" rel="icon" type="image/x-icon" />
	<link href="${ctx}/slider/slider.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.tools.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
	<script type="text/javascript" src="${ctx}/slider/slider.js"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	<style type="text/css">
		.header {
			margin-bottom: 0px;
		}
	</style>
<script type="text/javascript">
$().ready(function() {

	var $productCategoryMenuItem = $("#productCategoryMenu li");
	var $slider = $("#slider");
	var $newArticleTab = $("#newArticle ul.tab");
	var $hotGoodsImage = $("div.hotGoods img");
	
	$productCategoryMenuItem.hover(
		function() {
			$(this).children("div.menu").show();
		}, function() {
			$(this).children("div.menu").hide();
		}
	);
	
	$slider.nivoSlider({
		effect: "random",
		animSpeed: 1000,
		pauseTime: 6000,
		controlNav: true,
		keyboardNav: false,
		captionOpacity: 0.4
	});
	
	$newArticleTab.tabs("ul.tabContent", {
		tabs: "li",
		event: "mouseover"
	});
	
	$hotGoodsImage.lazyload({
		threshold: 100,
		effect: "fadeIn",
		skip_invisible: false
	});

});
</script>
</head>
<body>
<script type="text/javascript">
$().ready(function() {

	var $headerName = $("#headerName");
	var $headerLogin = $("#headerLogin");
	var $headerRegister = $("#headerRegister");
	var $headerLogout = $("#headerLogout");
	var $goodsSearchForm = $("#goodsSearchForm");
	var $keyword = $("#goodsSearchForm input");
	var defaultKeyword = "商品搜索";
	
	var username = getCookie("username");
	var nickname = getCookie("nickname");
	if ($.trim(nickname) != "") {
		$headerName.text(nickname).show();
		$headerLogout.show();
	} else if ($.trim(username) != "") {
		$headerName.text(username).show();
		$headerLogout.show();
	} else {
		$headerLogin.show();
		$headerRegister.show();
	}
	
	$keyword.focus(function() {
		if ($.trim($keyword.val()) == defaultKeyword) {
			$keyword.val("");
		}
	});
	
	$keyword.blur(function() {
		if ($.trim($keyword.val()) == "") {
			$keyword.val(defaultKeyword);
		}
	});
	
	$goodsSearchForm.submit(function() {
		if ($.trim($keyword.val()) == "" || $keyword.val() == defaultKeyword) {
			return false;
		}
	});

});
</script>
<div class="header">
	<div class="top">
		<div class="topNav">
			<ul class="left">
				<li>
					<span>您好，欢迎来到商HAI购</span>
				</li>
				<li id="headerLogin" class="headerLogin">
					<a href="/login">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister">
					<a href="/register">注册</a>
				</li>
			</ul>
			<ul class="right">
			
						[@navigation_list position=0]
							[#if navigations?has_content]
								[#list navigations as navigation]
									<li>
										<a href="${ctx }${navigation.url}" [#if navigation.isBlankTarget==1 ] target="_block"[/#if] >
											${navigation.name }
										</a>|
									</li>
								[/#list]
							[/#if]
						[/@navigation_list]
						
				<li id="headerCart" class="headerCart">
					<a href="/cart/list">购物车</a>
					(<em>0</em>)
				</li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span3">
				<a href="${ctx}/index">
					<img src="${ctx}/upload/image/logo.gif" alt="尚HAI购" />
				</a>
			</div>
			<div class="span6">
				<div class="search">
					<form id="goodsSearchForm" action="${ctx}/goods/search" method="get">
						<input name="keyword" class="keyword" value="" autocomplete="off" x-webkit-speech="x-webkit-speech" x-webkit-grammar="builtin:search" maxlength="30" />
						<button type="submit">&nbsp;</button>
					</form>
				</div>
				<div class="hotSearch">
					热门搜索:
					[@hot_srarch_keys]
						[#if keywords?has_content]
							[#list keywords as keyword]
								<a href="${ctx}/goods/search?keyword=${keyword}">${keyword}</a>
							[/#list]
						[/#if]
					[/@hot_srarch_keys]
				</div>
			</div>
			<div class="span3">
				<div class="phone">
					<em>服务电话</em>
					800-8888888
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<dl class="mainNav">
					<dt>
						<a href="/product_category">所有商品分类</a>
					</dt>
					
						[@navigation_list position=1]
							[#if navigations?has_content]
								[#list navigations as navigation]
									<dd>
										<a href="${navigation.url }" >
											${navigation.name }
										</a>
									</dd>
								[/#list]
							[/#if]
						[/@navigation_list]
							
				</dl>
			</div>
		</div>
	</div>
</div>
<script>
	$.post("/cart/count", {}, function (data) {
		if (data.resultCode == 1) {
			var count = data.result;
			$("#headerCart").find('em').html(count);
		}
	});
</script>	<div class="container index">
		<div class="row">
			<div class="span2">
					<div id="productCategoryMenu" class="productCategoryMenu">
						<ul>
							[@product_category_root_list count = 6]
								[#if productCateGories?has_content]
										[#list productCateGories as productCateGory ]
											<li>
													<div class="item">
														<div>
															[@product_category_children_list count=3 productCategoryId=productCateGory.id]
																[#if productChildrenCateGories?has_content]
																	[#list productChildrenCateGories as productChildrenCateGory]
																			<a href="${ctx}/goods/list/${productChildrenCateGory.id}">
																				<strong>${productChildrenCateGory.name}</strong>
																			</a>
																	[/#list]
																[/#if]
															[/@product_category_children_list]
														</div>
														<div>
															[@brand_list productCategoryId=productCateGory.id count=4]
																[#if brands?has_content]
																	[#list brands as brand]
																		<a href="${ctx}/brand/list/${brand.id}">${brand.name}</a>
																	[/#list]
																[/#if]
															[/@brand_list]
														</div>
													</div>
													[#--展开分类--]
													<div class="menu">
														
																
															[@product_category_children_list count=7 productCategoryId=productCateGory.id]
																[#if productChildrenCateGories?has_content]
																	[#list productChildrenCateGories as productChildrenCateGory]
																		<dl class="clearfix[#if !productChildrenCateGory_has_next] last[/#if]">
																			<dt>
																				<a href="${ctx}/goods/list/${productCateGory.id}">${productChildrenCateGory.name}</a>
																			</dt>
																			[@product_category_children_list count=6 productCategoryId=productChildrenCateGory.id]
																				[#if productChildrenCateGories?has_content]
																					[#list productChildrenCateGories as productChildrenCateGory]
																						<dd>
																							<a href="${ctx}/goods/list/${productChildrenCateGory.id}">${productChildrenCateGory.name}</a>|
																						</dd>
																					[/#list]
																				[/#if]
																			[/@product_category_children_list]
																		</dl>
																	[/#list]
																[/#if]
															[/@product_category_children_list ]
														</dl>
														[#--推荐品牌--]	
														<div class="auxiliary">
															[@brand_list productCategoryId=productCateGory.id count=8]
																[#if brands?has_content]
																	<div>
																		<strong>推荐品牌</strong>
																		[#list brands as brand]
																			<a href="${ctx}/brand/list/${brand.id}">${brand.name}</a>
																		[/#list]
																	</div>
																[/#if]
															[/@brand_list]
															[#--热门促销--]
															[@promotion_list productCategoryId=productCateGory.id count=4 hasEnd=false ]
																[#if promotions?has_content]
																	<div>
																		<strong>热门促销</strong>
																		[#list promotions as promotion]
																			[#if promotion.image?has_content]
																				<a href="${ctx}/brand/list/${promotion.id}" title="${promotion.title}">
																					<img src="${promotion.image}" alt="${promotion.title}" />
																				</a>
																			[/#if]
																		[/#list]
																	</div>
																[/#if]
															[/@promotion_list]
														</div>
													</div>
											</li>
									[/#list]
								[/#if]
							[/@product_category_root_list]
						</ul>
					</div>
			</div>
			[#--中间滚动广告--]
			<div class="span10">
				[@ad_position id=1/]
			</div>
		</div>
		[#--第二个广告位--]
		<div class="row">
			<div class="span9">
					[@ad_position id=2/]		
			</div>
			<div class="span3">
						[@article_category_root_list count=2]
							<div id="newArticle" class="newArticle">
								[#if articleCategories?has_content]
								<ul class="tab">
										[#list articleCategories as articleCategory]
											<li>
												<a href="${ctx}/article_category/${articleCategory.id}" target="_blank">${articleCategory.name}</a>
											</li>
										[/#list]
									</ul>
									[#--获得分类下的文章--]
									[#list articleCategories as articleCategory]
										[@article_list articleCategoryId=articleCategory.id count=6]
											[#if articles?has_content]
												<ul class="tabContent">
													[#list articles as article]
														<li>
															<a href="${ctx}/article/${article.id}" title="${article.title}" target="_blank">${article.title}</a>
														</li>
													[/#list]
												</ul>
											[/#if]
										[/@article_list]
									[/#list]
								[/#if]
							</div>
					[/@article_category_root_list]
				</div>
		</div>
		[#--中间蓝牙广告--]
		<div class="row">
			<div class="span12">
				[@ad_position id=3/]
			</div>
		</div>
					[#--热门商品展示--]
					[@product_category_root_list count = 3]
						[#--获取分栏广告赋值给变量：adIterator--]
						[@ad_position id=4]
							[#if adPosition??]
								[#assign adIterator=adPosition.ads.iterator()]
							[/#if]
						[/@ad_position]
						[#--循环遍历--]
						[#if productCateGories?has_content]
							[#list productCateGories as productCateGory ]
								<div class="row">
									<div class="span12">
										<div class="hotGoods">
											<dl class="title${productCateGory.id}">
												<dt>
													<a href="${ctx}/goods/list/${productCateGory.id}">${productCateGory.name}</a>
												</dt>
												[#--获得子分类--]
												[@product_category_children_list count=7 productCategoryId=productCateGory.id]
													[#if productChildrenCateGories?has_content]
														[#list productChildrenCateGories as productChildrenCateGory]
															<dd>
																<a href="${ctx}/goods/list/${productChildrenCateGory.id}">${productChildrenCateGory.name}</a>
															</dd>
														[/#list]
													[/#if]
												[/@product_category_children_list]
											</dl>
											[#--广告位--]
											[#if adIterator?? && adIterator.hasNext()]
												[#assign ad=adIterator.next()/]
												<div>
													[#if ad.url??]
														<a href="${ad.url}">
															<img src="${ad.path}" alt="${ad.title}" title="${ad.title}" />
														</a>
													[/#if]
												</div>
											[/#if]
											[#--分类下的热门商品--]
											[@good_list productCategoryId=productCateGory.id count=10 tagId=3]
												<ul>
													[#list goods as good]
														[#if good_index<5]
															<li>
																<a href="${ctx}/good/${good.id}" title="${good.name}" target="_blank">
																	<div>
																			<span title="${good.name}">${good.name}</span>
																			<em title="${good.caption}">${good.caption}</em>
																	</div>
																	<strong>￥${good.price}</strong>
																	<img src="${ctx}/upload/image/blank.gif" data-original="${good.image}" />
																</a>
															</li>
															[#else]
																<li class="low">
																	<a href="${ctx}/good/${good.id}" title="${good.name}" target="_blank">
																		<img src="${ctx}/upload/image/blank.gif" data-original="${good.image}" />
																		<span title="${good.name}">${good.name}</span>
																		<strong>￥${good.price}</strong>
																	</a>
																</li>
														[/#if]
													[/#list]
												</ul>
											[/@good_list]
										</div>
									</div>	
								</div>	
							[/#list]
						[/#if]
					[/@product_category_root_list]
		[#--底部广告--]	
		<div class="row">
			<div class="span12">
				[@ad_position id=5/]
			</div>
		</div>
		
		[#--热门品牌--]
		<div class="row">
			<div class="span12">
						<div class="hotBrand">
							<ul class="clearfix">
								[@brand_list  count=10]
									[#list brands as brand]
										<li>
											<a href="${ctx}/brand/${brand.id}" title="${brand.name}">
												<img src="${brand.logo}" alt="${brand.name}" />
											</a>
										</li>
									[/#list]
								[/@brand_list]	
							</ul>
						</div>
			</div>
		</div>
	</div>
	[#--底部--]
	[#include "include/footer.ftl"]
</body>
</html>