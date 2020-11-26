var q4 = function () {
  emit(this.nationality, { H: [this.height], W: [this.weight], count: 1 });
};
var res = function (k, val) {
  crlist = { H: [], W: [], count: 0 };
  for (var i = 0; i < val.length; i++) {
    crlist.H = val[i].H.concat(crlist.H);
    crlist.W = val[i].W.concat(crlist.W);
    crlist.count += val[i].count;
  }
  return crlist;
};
function Output(key, v) {
  var sumBMI = 0, minBMI = v.W[0] / v.H[0] / v.H[0] * 10000, maxBMI = minBMI;
  for (var i = 0; i < v.W.length; i++) {
    BMI = v.W[i] / v.H[i] / v.H[i] * 10000;
    minBMI = BMI < minBMI ? BMI : minBMI
    maxBMI = BMI > maxBMI ? BMI : maxBMI
    sumBMI += BMI
  }
  return { avgBMI: sumBMI / v.count, minBMI: minBMI, maxBMI: maxBMI };
};
db.qwerty.mapReduce(q4, res, { out: "BMI", finalize: Output })
printjson(db.BMI.find().toArray())

