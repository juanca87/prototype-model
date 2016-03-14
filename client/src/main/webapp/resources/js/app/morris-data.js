$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{  
                 atributo: 'Ancho de banda',
                 amazon: 63565,
                 google: 63564,
                 heroku: 63557
              }, {  
                 atributo: 'CPU',
                 amazon: 0244,
                 google: 0243,
                 heroku: 0244
              }, {  
                 atributo: 'Escritura en Disco',
                 amazon: 16827,
                 google: 16727,
                 heroku: 16027
              }, {  
                 atributo: 'Escritura en Memoria',
                 amazon:26000,
                 google:26200,
                 heroku:26000
              }, {  
                 atributo: 'Instrucciones por Minuto',
                 amazon: 40288,
                 google: 40388,
                 heroku: 40988
              }, {  
                 atributo: 'Latencia',
                 amazon: 22345,
                 google: 22345,
                 heroku: 22345
              }, {  
                 atributo: 'Lectura en Disco',
                 amazon: 25315,
                 google: 25215,
                 heroku: 25515
              }, {  
                 atributo: 'Lectura en Memoria',
                 amazon: 16000,
                 google: 16000,
                 heroku: 16000
              }],
        parseTime: false,
        xkey: 'atributo',
        ykeys: ['amazon', 'google', 'heroku'],
        labels: ['Amazon EC2', 'Google App Engine', 'Heroku'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });


//    Morris.Donut({
//        element: 'morris-donut-chart',
//        data: [{
//            label: "Download Sales",
//            value: 12
//        }, {
//            label: "In-Store Sales",
//            value: 30
//        }, {
//            label: "Mail-Order Sales",
//            value: 20
//        }],
//        resize: true
//    });
//
//    Morris.Bar({
//        element: 'morris-bar-chart',
//        data: [{
//            y: '2006',
//            a: 100,
//            b: 90
//        }, {
//            y: '2007',
//            a: 75,
//            b: 65
//        }, {
//            y: '2008',
//            a: 50,
//            b: 40
//        }, {
//            y: '2009',
//            a: 75,
//            b: 65
//        }, {
//            y: '2010',
//            a: 50,
//            b: 40
//        }, {
//            y: '2011',
//            a: 75,
//            b: 65
//        }, {
//            y: '2012',
//            a: 100,
//            b: 90
//        }],
//        xkey: 'y',
//        ykeys: ['a', 'b'],
//        labels: ['Series A', 'Series B'],
//        hideHover: 'auto',
//        resize: true
//    });

});
