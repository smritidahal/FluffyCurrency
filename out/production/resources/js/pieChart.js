google.charts.load('current', {
    'packages': ['corechart']
});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var data = google.visualization.arrayToDataTable([
        ['Crypto-Type', 'Value'],
        ['BTC', 1000],
        ['RPL', 2400],
        ['ETH', 1200],
        ['LTC', 180],
        ['BTG', 210]
    ]);

    var options = {
        title: 'My Crypt-Folio'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
}