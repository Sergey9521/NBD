var q5 = function () {
    if (this.sex == "Female" && this.nationality == "Poland") {


        // return
        for (var i = 0; i < this.credit.length; i++)
            emit(this.credit[i].currency, { balance: this.credit[i].balance, count: 1 });
    }
}; var r = function (key, val) {
    var reducedVal = { balance: 0, count: 0 }
    val.forEach(val => {
        reducedVal.count += val.count;
        reducedVal.balance += parseFloat(val.balance);
    })
    return reducedVal;
}; function Output(key, v) {
    return { avgBalance: v.balance / v.count, totalBalance: v.balance };
} var result = { out: "avg_and_total_balance", finalize: Output };
db.qwerty.mapReduce(q5, r, result)
printjson(db.avg_and_total_balance.find({}).toArray())
