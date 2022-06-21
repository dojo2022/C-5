  var ctx = document.getElementById("myChart");
  var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['8月1日', '8月2日', '8月3日', '8月4日', '8月5日', '8月6日', '8月7日'],
      //foreach使えば行けるのでは
      datasets: [
        {
          label: '体重推移',
          data: [60.2, 60.4, 59.8, 60.1, 58.7, 58.0, 57.1, 56.4],
          //ここもforeach
          borderColor: "rgba(255,0,0,1)",
          backgroundColor: "rgba(0,0,0,0)"
        }
      ],
    },
    options: {
      title: {
        display: true,
        text: '今までの体重推移'
      },
      scales: {
        yAxes: [{


        }]
      },
    }
  });