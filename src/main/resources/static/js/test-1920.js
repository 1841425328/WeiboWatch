// 基于准备好的dom，初始化echarts实例
var myChart1 = echarts.init(document.getElementById('main1'));
var myChart2 = echarts.init(document.getElementById('main2'));
var myChart3 = echarts.init(document.getElementById('main3'));
var myChart5 = echarts.init(document.getElementById('main5'));
var myChart6 = echarts.init(document.getElementById('main6'));
var myChart7 = echarts.init(document.getElementById('main7'));

getNowFormatDate();
init_myChart1();
init_myChart2();
init_myChart3();
init_myChart5();
init_myChart6();
init_myChart7();

/**
 * 左上图表
 */
function init_myChart1() {
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [
            {
                name: '用户浏览设备占比',
                type: 'pie',
                radius: '70%',
                center: ['50%', '50%'],
                data: [
                    {value: 1048, name: '浏览器'},
                    {value: 735, name: '微信'},
                    {value: 580, name: '安卓'},
                    {value: 484, name: '其他'},
                ],
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },
                label: {
                    show: true,
                    formatter: '{b} : {c} ({d}%)',
                    fontSize: 14,
                },
                labelLine: {show: true}
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option);

    // 定时更新数据
    function updateChart() {
        $.ajax({
            url: '/topSources',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // 成功获取数据后，更新饼图
                myChart1.setOption({
                    series: [{
                        data: data.map(function (item) {
                            return {value: item.count, name: item.source};
                        })
                    }]
                });
            },
            error: function (xhr, status, error) {
                console.error('载入数据失败：', error);
            }
        });
    }

    updateChart();
    // 设置定时器，每隔5秒执行一次updateChart函数
    setInterval(updateChart, 10000);

}

/**
 *中上图表
 */
// 绘制折线图的函数
function init_myChart2() {
    function loadData2() {
        $.ajax({
            url: '/top5',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // 成功获取数据后，将其用于绘制折线图
                var xAxisData = []; // x 轴数据
                var seriesData = []; // 曲线数据

                // 遍历每个数据对象
                data.forEach(function (item) {
                    console.log(item.keyword)
                    xAxisData.push(item.keyword); // x 轴数据为博客标题
                    seriesData.push([
                        item.reposts_count,
                        item.likes_count,
                        item.comments_count
                    ]); // 曲线数据为转发数、点赞数、评论数
                });

                var option = {
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['转发数', '点赞数', '评论数'],
                        textStyle: {
                            color: '#FFA500' // 图例文字颜色
                        }
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxisData,

                        axisLabel: {
                            color : "#87CEEB",
                            formatter: function(value) {
                                // 如果标签长度超过3个字符，就插入换行符
                                return value.length > 3 ? value.replace(/(?<!\n)(.{3})/g, '$1\n') : value;
                            },
                            rich: {
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            color: '#87CEEB' // y轴标签颜色
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#FFFFFF' // y轴线条颜色
                            }
                        }
                    },
                    series: [{
                        name: '转发数',
                        type: 'line',
                        smooth: true,
                        data: seriesData.map(function (item) {
                            return item[0];
                        }),
                        lineStyle: {
                            color: '#f00' // 线条颜色为红色
                        }
                    },
                        {
                            name: '点赞数',
                            type: 'line',
                            smooth: true,
                            data: seriesData.map(function (item) {
                                return item[1];
                            }),
                            lineStyle: {
                                color: '#0f0' // 线条颜色为绿色
                            }
                        },
                        {
                            name: '评论数',
                            type: 'line',
                            smooth: true,
                            data: seriesData.map(function (item) {
                                return item[2];
                            }),
                            lineStyle: {
                                color: '#00f' // 线条颜色为蓝色
                            }
                        }
                    ],
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart2.setOption(option);
            },
            error: function (xhr, status, error) {
                console.error('载入数据失败：', error);
            }
        });
    }

    // 初始加载数据
    loadData2();
    setInterval(loadData2, 10000);
}

/**
 *右上图表
 */
function init_myChart3() {
    function loadData3() {
        $.ajax({
            url: '/post-count',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.length === 0) {
                    return;
                }
                console.log(data);
                var mediaPostCount = data.map(function (item) {
                    return item.mediaPostCount;
                });
                var noMediaPostCount = data.map(function (item) {
                    return item.noMediaPostCount;
                });

                var chartData = [
                    {value: mediaPostCount.reduce((a, b) => a + b, 0), name: '多媒体博文'},
                    {value: noMediaPostCount.reduce((a, b) => a + b, 0), name: '非多媒体博文'}
                ];

                var option = {
                    title: {
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b}: {c} ({d}%)'
                    },
                    series: [
                        {
                            name: '博文类型',
                            type: 'pie',
                            radius: '70%',
                            data: chartData,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    color: '#87CEEB'
                                },
                                normal: {
                                    color: function (params) {
                                        var colorList = [
                                            '#87CEFA', // 第一个扇区的颜色
                                            '#FFB771', // 第二个扇区的颜色
                                        ];
                                        return colorList[params.dataIndex];
                                    }
                                }
                            }
                        }
                    ]
                };
                myChart3.setOption(option);
            },
            error: function (xhr, status, error) {
                console.error('Failed to load data:', error);
            }
        });
    }
    loadData3();
    setInterval(loadData3, 10000);
}

/**
 * 中右图表
 */
function init_myChart5() {
    function loadData4() {
        $.ajax({
            url: '/bloggerTop10',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                var option = {
                    tooltip: {},
                    legend: {
                        data: ['柱状图'],
                        color: '#FFB754',
                        textStyle: {
                            color: '#FFB754'
                        }
                    },
                    xAxis: {
                        data: data.map(function (item) {
                            return item.blogger;
                        }),
                        axisLabel: {
                            color: '#1E90FF' // x轴标签颜色
                        }
                    },
                    yAxis: {
                        axisLabel: {
                            color: '#1E90FF' // x轴标签颜色
                        }
                    },
                    series: [{
                        name: '柱状图',
                        type: 'bar',
                        data: data.map(function (item) {
                            return item.total_likes;
                        }),
                        itemStyle: {
                            normal: {
                                color: function (params) {
                                    var colorList = [
                                        '#FFB754', '#FFC771', '#FFD866', '#FFE961',
                                        '#FFF961', '#FFFA66', '#FFF771', '#FFF961',
                                        '#FFF866', '#FFF771'
                                    ];
                                    return colorList[params.dataIndex % colorList.length];
                                }
                            }
                        }
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart5.setOption(option);
            },
        });
    }

    loadData4();
    setInterval(loadData4, 10000);
}


function init_myChart6() {
    function loadData5() {
        $.ajax({
            url: '/predictions',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log("成功获取到数据");
                console.log(data);

                // 准备散点图的数据
                var chartData = data.map(function(item, index) {
                    return [index, item.prediction, item.keyword];
                });

                // 设置散点图的配置项
                var option = {
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: data.map(function(item) { return item.keyword; }),
                        axisLine: {
                            lineStyle: {
                                color: '#87CEEB'
                            }
                        },
                        axisLabel: {
                            color: '#87CEEB', // 设置字体颜色为天蓝色
                            formatter: function(value) {
                                // 如果标签长度超过4个字符，就插入换行符
                                return value.length > 4 ? value.replace(/(?<!\n)(.{4})/g, '$1\n') : value;
                            },
                            rich: {
                                // 可以在这里定义富文本样式
                            }
                        }
                    },
                    yAxis: {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: '#87CEEB'
                            }
                        },
                        axisLabel: {
                            color: '#87CEEB', // 设置字体颜色为天蓝色
                        },
                    },
                    series: [{
                        data: chartData,
                        type: 'scatter',
                        itemStyle: {
                            shadowBlur: 10,
                            shadowColor: 'rgba(0, 0, 0, 0.3)',
                            borderColor: '#fff', // 设置边框颜色
                            borderWidth: 1
                        },
                        label: {
                            emphasis: {
                                show: true,
                                formatter: function (param) {
                                    return param.data[2] + ': ' + param.data[1];
                                },
                                position: 'top'
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: function (params) {
                                return params.seriesName + '<br/>' + params.data[2] + ': ' + params.data[1];
                            }
                        }
                    }]
                };

                // 使用配置项显示图表
                myChart6.setOption(option);
            },
        });
    }
    loadData5();
    setInterval(loadData5, 10000); // 每10秒更新一次数据
}



function init_myChart7() {
    function fetchData() {
        $.ajax({
            url: '/keyword-stats', // 服务器端点
            type: 'GET', // 请求类型
            success: function(data) {
                console.log(data);
                // 定义极端值的阈值
                var maxThreshold = 3000;
                // 过滤极端值
                var filteredData = data.filter(function(item) {
                    return item.reposts_Count <= maxThreshold && item.comments_Count <= maxThreshold;
                });

                var seriesData = [];
                filteredData.forEach(function(item) {
                    seriesData.push([item.reposts_Count, item.comments_Count]);
                });

                var option = {
                    title: {
                        text: '转发数 vs 评论数',
                        left: 'center',
                        textStyle: {
                            fontSize: 18,
                            fontWeight: 'bold',
                            color: '#87CEEB' // 将字体颜色改为黑色
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: function(params) {
                            return '转发数: ' + params.value[0] + '<br>评论数: ' + params.value[1];
                        }
                    },
                    xAxis: {
                        name: '转发数',
                        type: 'value',
                        nameTextStyle: {
                            fontSize: 14,
                            color: '#87CEEB' // 将字体颜色改为黑色
                        },
                        axisLabel: {
                            fontSize: 12,
                            color: '#87CEEB' // 将字体颜色改为黑色
                        }
                    },
                    yAxis: {
                        name: '评论数',
                        type: 'value',
                        nameTextStyle: {
                            fontSize: 14,
                            color: '#87CEEB' // 将字体颜色改为黑色
                        },
                        axisLabel: {
                            fontSize: 12,
                            color: '#87CEEB' // 将字体颜色改为黑色
                        }
                    },
                    series: [{
                        type: 'scatter', // 散点图类型
                        data: seriesData,
                        symbolSize: function (data) {
                            // 根据数据大小调整点的大小
                            return Math.sqrt(data[0] + data[1]) / 5;
                        },
                        itemStyle: {
                            shadowBlur: 10,
                            shadowColor: 'rgba(120, 36, 50, 0.5)',
                            shadowOffsetY: 5,
                            color: new echarts.graphic.RadialGradient(0.4, 0.3, 1, [
                                {offset: 0, color: 'rgb(251, 118, 123)'},
                                {offset: 1, color: 'rgb(204, 46, 72)'}
                            ])
                        }
                    }]
                };

                // 使用指定的配置项和数据显示图表。
                myChart7.setOption(option);
            }
        });
    }


    fetchData();
    setInterval(fetchData, 10000); // 每10秒更新一次数据
}


//获取当前时间
function getNowFormatDate() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var Hour = date.getHours();       // 获取当前小时数(0-23)
    var Minute = date.getMinutes();     // 获取当前分钟数(0-59)
    var Second = date.getSeconds();     // 获取当前秒数(0-59)
    var show_day = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
    var day = date.getDay();
    if (Hour < 10) {
        Hour = "0" + Hour;
    }
    if (Minute < 10) {
        Minute = "0" + Minute;
    }
    if (Second < 10) {
        Second = "0" + Second;
    }
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = '<div><p>' + year + '年' + month + '月' + strDate + '号</p><p>' + show_day[day] + '</p></div>';
    var HMS = Hour + ':' + Minute + ':' + Second;
    var temp_time = year + '-' + month + '-' + strDate + ' ' + HMS;
    $('.nowTime li:nth-child(1)').html(HMS);
    $('.nowTime li:nth-child(2)').html(currentdate);
    //$('.topRec_List li div:nth-child(3)').html(temp_time);
    setTimeout(getNowFormatDate, 1000);//每隔1秒重新调用一次该函数
}


