
document.addEventListener('DOMContentLoaded', function() {
	// タブに対してクリックイベントを適用
	const tabs = document.getElementsByClassName('tab');
	for (let i = 0; i < tabs.length; i++) {
		tabs[i].addEventListener('click', tabSwitch, false);
	}

	// タブをクリックすると実行する関数
	function tabSwitch() {
		// タブのclassの値を変更
		document.getElementsByClassName('is-active')[0].classList.remove('is-active');
		this.classList.add('is-active');
		// コンテンツのclassの値を変更
		document.getElementsByClassName('is-show')[0].classList.remove('is-show');
		const arrayTabs = Array.prototype.slice.call(tabs);
		const index = arrayTabs.indexOf(this);
		document.getElementsByClassName('panel')[index].classList.add('is-show');
	};
}, false);

/*-----------------------------------------------------------------------------*/


document.addEventListener('DOMContentLoaded', function() {
	// タブに対してクリックイベントを適用
	const avaters = document.getElementsByClassName('avater');
	for (let j = 0; j < avaters.length; j++) {
		avaters[j].addEventListener('click', avaterSwitch, false);
	}

	// タブをクリックすると実行する関数
	function avaterSwitch() {
		// タブのclassの値を変更
		document.getElementsByClassName('is-active-avater')[0].classList.remove('is-active-avater');
		this.classList.add('is-active-avater');
		// コンテンツのclassの値を変更
		document.getElementsByClassName('is-show-avater')[0].classList.remove('is-show-avater');
		const arrayAvaters = Array.prototype.slice.call(avaters);
		const index = arrayAvaters.indexOf(this);
		document.getElementsByClassName('photo')[index].classList.add('is-show-avater');
	};
}, false);