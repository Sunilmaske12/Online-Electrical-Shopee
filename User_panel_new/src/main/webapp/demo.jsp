<%@page import="com.codeo.shop.Dao.DailyBusiness"%>
<%@page import="java.util.*"%>

<html>
<head>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script> 
      <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@0.4.0/dist/chartjs-plugin-datalabels.min.js"></script> 
      
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<%
DailyBusiness db=new DailyBusiness();
int[] status = db.getStatus();//total-success-reject-wait
int total=status[0];
int success=status[1];
int reject=status[2];
int wait=status[3];
%>


	<div >
		<canvas style="max-height: 600px; max-width: 600px;" id="myChartStatus"></canvas>
	</div>

	<script type="text/javascript">
		var ctx = document.getElementById("myChartStatus").getContext("2d");
		let a=<%=total%>;
		let b=<%=success%>;
		let c=<%=reject%>;
		let d=<%=wait%>;
		var myChart = new Chart(ctx, {
			type : "pie",
			
			data : {
				labels: [
				    'Approved',
				    'Rejected',
				    'Waiting'
				  ],
				  datasets: [{
				    data: [b,c,d],
				    backgroundColor: [
				      'green',
				    	'red',
					      'yellow',
				    ],
				    hoverOffset: 4,
				  }],
			},
		options:{
	  		plugins:{
	  			legend:{
	  				display:false
	  			}
	  		},datalabels: {
	  	       formatter: (value, ctx) => {
	  	         let datasets = ctx.chart.data.datasets;
	  	         if (datasets.indexOf(ctx.dataset) === datasets.length - 1) {
	  	           let sum = datasets[0].data.reduce((a, b) => a + b, 0);
	  	           let percentage = Math.round((value / sum) * 100) + '%';
	  	           return percentage;
	  	         } else {
	  	           return percentage;
	  	         }
	  	       },
	  	     color: '#fff',
	  		}
	  		
		}

		})
	</script>





</body>
</html>