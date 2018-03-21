// taken from https://github.com/pa7/heatmap.js (MIT-licensed)
var data = [[38,20,2],[1600,20,2]];


for (var i = 0; i <200; i++)
{
    x = 700 + 450*Math.random();
    y = 900*Math.random();
    data.push([x,y]);
}

for (var i = 0; i <80; i++)
{
    x = 600+1000*Math.random();
    y = 250*Math.random();
    data.push([x,y]);
}

for (var i = 0; i <80; i++)
{
    x = 600+1000*Math.random();
    y = 250*Math.random();
    data.push([x,y]);
}
