
'use strict'

const checkGet = document.getElementsByName('long_ans');
  checkGet.forEach((long_ans) => {
    long_ans.addEventListener('click', () => {
      if(long_ans.checked) {
        checkGet.forEach((allChecks) => {
          allChecks.checked = false;
        });
        long_ans.checked = true;
      }
    });
  });

/**チェックボックスのname属性を入れる箇所は5か所
**/

