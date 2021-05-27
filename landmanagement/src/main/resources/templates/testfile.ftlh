<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title></title>
		<style>
			*{
				margin: 0;
				padding: 0;
				box-sizing: border-box;
			}
			body{
				font-family: SimSun;
			}
			section{
				display:block;
				margin: 20px 10px;
			}
			.title{
				text-align: center;
			}
			.preface p{
				line-height: 30px;
			}
			.preface p.content{
				text-indent: 2em;
			}
			section > table{
				table-layout: fixed;
				width: 100%;
				margin: 20px 0px;
				text-align:center;
				word-wrap:break-word;
			}
			section table td{
				padding:5px 0px;
			}
		</style>
	</head>
	<body>
		<!-- Title start -->
		<section class="title">
			<h2>a report</h2>
		</section>
		<!-- Title end -->
		
		<!-- Foreword start -->
		<section class="preface">
			<p>respected ${name}:</p>
			<p class="content">Content content content content content content content content content content content content content content content content content content content content content</p>
		</section>
		<!-- Foreword end -->
		
		<!-- Summary statistics start -->
		<section class="count-info">
			<h4>Summary statistics</h4>
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td>The number of this month</td>
					<td>Comparison of quantity in the past three months</td>
				</tr>
				<tr>
					<td>${curr}</td>
					<td>
						<table width="80%" border="1" cellspacing="0" cellpadding="0" style="margin: 5px auto;">
							<tr>
								<td>${one}</td>
								<td>${two}</td>
								<td>${three}</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</section>
		<!-- Summary statistics end -->
		
		<!-- Detail start -->
		<section class="detail">
			<h4>Detail</h4>
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td width="5%">Serial number</td>
					<td width="15%">Column 1</td>
					<td width="12%">Column 2</td>
					<td width="12%">Column 3</td>
					<td width="12%">Column 4</td>
					<td>Column 5</td>
				</tr>
				<#list detailList as ad>
					<tr>
						<td>${ad_index+1}</td>
						<td>${ad.column1}</td>
						<td>${ad.column2}</td>
						<td>${ad.column3}</td>
						<td>${ad.column4}</td>
						<td>${ad.column5}</td>
					</tr>
				</#list>
			</table>
		</section>
		<!--Details end -->
		<img src="bg.png" width="600px"/>
	</body>
</html>
