function clOK() {
    let inputElement = document.getElementById('pwd');
    if (lpwd != md5(inputElement.value)) {
        alert("密码错误~");
        return false;
    }
    setWithExpiry(key, value, ttl);
    let url = getWithExpiry("lastVisitedUrl");
    if (url == null) {
        url = "/";
    }
    window.location.href = url;
}
function clClean() {
    document.getElementById('pwd').value="";
}

// 设置带有过期时间的 localStorage 项
function setWithExpiry(key, value, ttl) {
    const now = new Date();
    // ttl 是过期时间（单位：毫秒）
    const item = {
        value: value,
        expiry: now.getTime() + ttl,
    };
    localStorage.setItem(key, JSON.stringify(item));
}

// 获取 localStorage 项，检查其是否过期
function getWithExpiry(key) {
    const itemStr = localStorage.getItem(key);
    if (!itemStr) {
        return null;
    }
    const item = JSON.parse(itemStr);
    const now = new Date();
    if (now.getTime() > item.expiry) {
        localStorage.removeItem(key);
        return null;
    }
    return item.value;
}

// 使用示例
const key = "pass";
const value = "true";
// const ttl = 10000; // 10 秒
const ttl = 300000; // 5 分钟 (5 * 60 * 1000)
const lpwd = "c33367701511b4f6020ec61ded352059"; //加密

