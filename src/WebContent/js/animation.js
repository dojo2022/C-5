  var ctx = document.getElementById("myChart");
  var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['', '', '', '', '', '', '','', '', '', '', '', '', ''],
      //foreach使えば行けるのでは
      datasets: [
        {
          label: '体重推移',
          weight: [ , , , , , , , , , , , , , ],
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
  for(h=0;h<   .length;h++){
  for(i=0;i<14;i++){
  labels[i]=

  }
  }