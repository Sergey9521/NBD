var q2 = function () {
	for (var i = 0; i < this.credit.length; i++)
		emit(this.credit[i].currency, { balance: this.credit[i].balance });
};
var sum1 = function (k, val) {
	total = { balance: 0 }
	for (var i = 0; i < val.length; i++) {
		total.balance += parseFloat(val[i].balance)
	}
	return total;
	// console.log(val)
	// return Array.sum(parseFloat(val));
};
function totalB(key, v) {
	return {
		total: v.balance

	};
}
var result = { out: "total_balance", finalize: totalB };
db.qwerty.mapReduce(q2, sum1, result)
printjson(db.total_balance.find({}).toArray())
