 $npm install Mypage

  const labels = [
    '2022-0616',
    '2022-0617',
    '2022-0618',
    '2022-0619',
    '2022-0620',
    '2022-0621',
    '2022-0622',
    '2022-0623',
    '2022-0624',
    '2022-0625',
    '2022-0626',
    '2022-0627',
    '2022-0628',
    '2022-0629'
  ];

  const data = {
    labels: labels,
    datasets: [{
      label: '体重推移',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: [65.2, 60.0, 62.4, 67.4, 65.7, 63.3, 61.0,
             68.1, 62.0, 63.2, 69.4, 67.7, 64.3, 66.0],
    }]
  };

  const config = {
    type: 'line',
    data: data,
    options: {}
  };
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
/*---------------------------------------*/
 /* for(h=0;h<cardList.length;h++){
  for(i=0 ;i<14 ;i++){
  labels[i]=${cardList["date"]};
  weight[i]=${cardList["day"]}
  }
  }*/