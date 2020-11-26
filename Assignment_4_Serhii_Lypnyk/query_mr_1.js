var q1 = function () {
  emit(this.sex, { sumH: this.height, sumW: this.weight, count: 1 });
};
var r = function (k, val) {
  total = { sumH: 0, sumW: 0, count: 0 };
  for (var i = 0; i < val.length; i++) {
    total.sumH += parseFloat(val[i].sumH);
    total.sumW += parseFloat(val[i].sumW);
    total.count += val[i].count;
  }

  return total;
};
function avg_count(key, v) {
  return {
    avgHeight: v.sumH / v.count,
    avgWeight: v.sumW / v.count
  };
}
var result = { out: "avg_height_and_weight", finalize: avg_count };
db.qwerty.mapReduce(q1, r, result)
printjson(db.avg_height_and_weight.find({}).toArray())
