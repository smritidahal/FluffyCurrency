import json

def main():

    with open('coinfile2.txt', 'w') as file:
        with open('coins.txt') as json_file:
            coins = json.load(json_file)
            for coin in coins:
                #file.write("<option id='" + coin['id'] + "'>" + coin['symbol'] + " - " + coin['name'] + "</option>\n")
                file.write(coin['id']+",\n")

main()