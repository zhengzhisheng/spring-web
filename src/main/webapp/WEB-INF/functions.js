//货币的形式显示
export function showPayment(mon) {
    if (isNaN(mon) || mon == 0) {
        return '-';
    }
    let money = mon / 100;
    money = String(money);
    let left = money.split('.')[0], right = money.split('.')[1];
    right = right ? (right.length >= 2 ? '.' + right.substr(0, 2) : '.' + right + '0') : '.00';
    let temp = left.split('').reverse().join('').match(/(\d{1,3})/g);
    return (Number(money) < 0 ? "-" : "") + temp.join(',').split('').reverse().join('') + right;
}
//货币的形式显示
export function showPayment2(mon, defaultStr) {
    if (isNaN(mon) || mon == 0) {
        return defaultStr;
    }
    let money = mon / 100;
    money = String(money);
    let left = money.split('.')[0], right = money.split('.')[1];
    right = right ? (right.length >= 2 ? '.' + right.substr(0, 2) : '.' + right + '0') : '.00';
    let temp = left.split('').reverse().join('').match(/(\d{1,3})/g);
    return (Number(money) < 0 ? "-" : "") + temp.join(',').split('').reverse().join('') + right;
}

//分转换为元，若为空则显示defaultStr
export function fenToYuan(money, defaultStr) {
    if (isNaN(money)) {
        return defaultStr;
    }
    return money / 100;
}

//百分比显示
export function Percentage(value) {
    if (isNaN(value)) {
        return '-';
    }
    if (value === 0) {
        return "-";
    }
    return parseFloat(value) * 100 + "%";
}

//百分比显示，显示几位小数
export function PercentageToFixed(value, decimal) {
    if (isNaN(value) || isNaN(decimal)) {
        return '-';
    }
    if (value === 0) {
        return "-";
    }
    return parseFloat(value * 100).toFixed(decimal) + "%";
}

//可以显示默认
export function defaultView(value) {
    if (isNaN(value)) {
        return '-';
    }
    if (value === 0) {
        return "-";
    }
    return value;
}

//数据库分转为元，显示几位小数
export function YuanToFixed(value, decimal) {
    if (isNaN(value) && isNaN(decimal)) {
        return "";
    } else if (value == null) {
        return "";
    }else {
        var num = new Number(value)
        return parseFloat(num / 100).toFixed(decimal);
    }
}

//数据库百分数转化，显示几位小数
export function ToFixed(value, decimal) {
    if (isNaN(value) && isNaN(decimal)) {
        return "";
    } else if (value == null) {
        return "";
    } else {
        var num = new Number(value)
        return parseFloat(num * 100).toFixed(decimal);
    }
}

//百分比显示
export function Percentage2(value, defaultStr) {
    if (isNaN(value)) {
        return defaultStr;
    }
    if (value === 0) {
        return defaultStr;
    }
    value = value * 100 * 10000;
    value = Math.ceil(value) / 10000; //向上舍入
    return value + "%";
}

//
export function getUrlList(value) {
    let urls = [];
    if (isNaN(value)) {
        return urls;
    }
    return JSON.parse(value);
}
//获取年月日
export function getYMD(time) {
    if (!time) {
        return "--";
    }
    time = time.replace(new RegExp("-", "gm"), "/"); //为了适配所有的浏览器
    var date = new Date(time);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + add0(m) + '-' + add0(d);
}

export function parseJSON(jsonStr) {
    let jsonObj = null;
    try {
        jsonObj = JSON.parse(jsonStr);
    } catch (e) {
        console.log('解析json格式失败，解析内容：' + jsonStr);
    }
    return jsonObj;
}

function add0(m) {
    return m < 10 ? '0' + m : m;
}

//删除左右两端的空格
export function trim(str) {
    return str.replace(/ /g, "");
}

//判断是否是电话号码
export function isMobile(str) {
    let mobile = /^[1][3,4,5,7,8][0-9]{9}$/;
    return (mobile.test(str));
}

//金融产品ID自增
export function autoId(value) {
    let result = null;
    value = value + "";
    length = value.length;
    if (length == 1) {
        result = "000" + value;
    } else if (length == 2) {
        result = "00" + value;
    } else if (length == 3) {
        result = "0" + value;
    } else {
        result = value;
    }
    return result;
}
//小数判断
export function isDecimals(value) {
    if (null != value) {
        value = String(value);
        let difits = value.split(".")[1];
        if (null != difits) {
            return true
        }
    }
    return false;
}
//位数判断
export function isDigit(value) {
    if (null != value) {
        value = String(value);
        if (value.length > 7) {
            return true
        }
    }
    return false;
}
//小数点后两位
export function rateChange(value){
    let rule = /^([1-9]\d*|0)(\.\d{1,4})?$/;
    if (value) {
        return rule.test(value);
    }
}




