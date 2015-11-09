/**
 * 购物车添加
 */
function add(goodsId, goodsNum){
	//定义json
	var goods={
		"goodsId":goodsId,
		"goodsNum":goodsNum
	};
	var data;
	//购物车里没有物品，直接添加
	if($.cookie("shopcar")==null){
		data = [];
		data.push(goods);
	}else{
		data=get();
		addGoods(data,goods);
	}
	//添加到cookie中
	$.cookie("shopcar",JSON.stringify(data));
}
/*
 * 将goods添加到goodses中
 * goods有可能出现在goodses中，做判断
 */
function addGoods(goodses, goods){
	for(var i=0;i<goodses.length;i++){
		//商品存在于购物车中
		if(goods.goodsId==goodses[i].goodsId){
			goodses[i].goodsNum=parseInt(goodses[i].goodsNum)+parseInt(goods.goodsNum);
			return;
		}
		
	}
	goodses.push(goods);
}
/*
 * 得到购物车原有的值
 */
function get() {
	var goodses = $.cookie("shopcar");
	if(goodses==null){
		return [];
	}
	return JSON.parse(goodses);
}

//将src加入到target中
function addJSON(target,src){
	for(var p in src){
		target[p]=src[p];
	}
}

function getGoodsNumById(goodses, goodsId){
	//goodses中的商品id与传入id等，返回其数量
	for(var i=0;i<goodses.length;i++){
		if(goodsId==goodses[i].goodsId){
			return goodses[i].goodsNum;
		}
	}
}













