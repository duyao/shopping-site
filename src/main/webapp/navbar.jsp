<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function() {
		$('.mycart').hover(function() {
			$('#div_mycart').show('slow');
		}, function() {
			$('#div_mycart').hide('slow');
		});
	});
</script>
<div class="navbar">
	<ul>
		<c:forEach items="${categories}" var="category">
				<li><a href="goods_listByCate?goods.categoryId=${category.id }">${category.name}</a></li>
		</c:forEach>
		
	</ul>

	<div class="mycart">
		<dl>
			<dt>
				<a href="cart.jsp">购物车<b name="mycart_count">1</b>件
				</a>
			</dt>
			<dd>
				<a href="cart.jsp">去结算</a>
			</dd>
		</dl>

		<!--购物车浮动div 开始-->
		<div class="shopping" id="div_mycart" style="display: none;">
			<dl class="cartlist">
				<dd id="site_cart_dd_0">
					<div class="pic f_l">
						<img width="55" height="55" src="images/goods/apple.jpg">
					</div>
					<h3 class="title f_l">
						<a href="">苹果（Apple）iPhone 6 (A1586) 64GB</a>
					</h3>
					<div class="price f_r t_r">
						<b class="block">￥5688.00 x 1</b> <input class="del" type="button"
							value="删除" onclick="">
					</div>
				</dd>


				<dd class="static">
					<span>共<b name="mycart_count">1</b>件商品
					</span>金额总计：<b name="mycart_sum">￥5688.00</b>
				</dd>

				<dd class="static">
					<label class="btn_orange"><input type="button"
						value="去购物车结算" onclick="location.href='cart.jsp'"></label>
				</dd>

			</dl>
		</div>

	</div>
</div>