
'use strict'

'use strict'

const checkGet = document.getElementsByName('short_ans');
  checkGet.forEach((short_ans) => {
    short_ans.addEventListener('click', () => {
      if(short_ans.checked) {
        checkGet.forEach((allChecks) => {
          allChecks.checked = false;
        });
        short_ans.checked = true;
      }
    });
  });