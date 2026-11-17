# -------------------------------------------------------
# CS 127, Lab 13
# Your Name(s): Spencer Colety
# November 28, 2023
# -------------------------------------------------------

import numpy as np

# -------------------------------------------------------

class WackyPackageCard:
    def __init__(self, number, description, value):
        self.number = number
        self.description = description
        self.value = value
        self.cards_owned = 0

    def __str__(self):
        return "{:<10d}{:25}{:<10.2f}{:<10d}".format(self.number, self.description, self.value, self.cards_owned)

    def get_number(self):
        return self.number

    def get_description(self):
        return self.description

    def get_value(self):
        return self.value

    def get_cards_owned(self):
        return self.cards_owned

    def set_cards_owned(self, number):
        self.cards_owned = number

# -------------------------------------------------------

class WackyPackageSeries:
    #changed the dtype to object to help it run
    def __init__(self, manufacturer, year, how_many):
        self.manufacturer = manufacturer
        self.year = year
        self.how_many = how_many
        self.cards = np.empty(how_many, dtype=object)

    def __str__(self):
        result = "My " + str(self.year) + " collection of " + self.manufacturer + " Topps Wacky Packages\n\n"
        result += "{:10}{:25}{:10}{:10}\n".format("Number", "Description", "Value", "Owned")
        result += "{:10}{:25}{:10}{:10}\n".format("------", "-----------", "-----", "-----")
        for card in self.cards:
            result += WackyPackageCard.__str__(card) + "\n"
        return result
    #made it handle index and convert values to float
    def process_series_information(self, file_name):
        file = open(file_name, "r")
        for line in file:
            values = line.strip().split(",")
            index = int(values[0]) - 1
            self.cards[index] = WackyPackageCard(int(values[0]), values[1], float(values[2]))
        file.close()    
    #check for case sensitive and no values
    def process_collection_information(self, file_name):
        file = open(file_name, "r")
        for my_card in file:
            my_card = " ".join(my_card.split())
            for card in self.cards:
                if card is not None and card.get_description().lower() == my_card.lower():
                    card.set_cards_owned(card.get_cards_owned() + 1)
                    break
        file.close()
    #made the collection value work
    def collection_value(self):
        value = 0
        for card in self.cards:
            if card is not None:
                value += card.get_value() * card.get_cards_owned()
        return value
    #changed it to handle none and missing counts correctly.
    def determine_missing_information(self):
        missing_cards = 0
        missing_value = 0
        for card in self.cards:
            if card is not None and card.get_cards_owned() == 0:
                missing_cards += 1
                missing_value += card.get_value()
        return missing_cards, missing_value


# -------------------------------------------------------

def main():
    my_collection = WackyPackageSeries("Topps", 1973, 30)
    my_collection.process_series_information("series1.csv")
    print(my_collection)
    my_collection.process_collection_information("my_cards.csv")
    print(my_collection)
    print("Value of collection = ${:.2f}".format(my_collection.collection_value()))
    number_of_missing_cards, cost_of_missing_cards = my_collection.determine_missing_information()
    print("Number of missing cards =", number_of_missing_cards)
    print("Cost of purchasing missing cards = ${:.2f}".format(cost_of_missing_cards))

# -------------------------------------------------------

main()
