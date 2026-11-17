# Card Collection Analyzer
**Python · November 28, 2023 · Objects & data processing**

Load a trading-card catalog and a collection list, match card names, and calculate the collection's value and missing cards.

## Code tour

Read [Spencer-Colety-Lab13.py](Spencer-Colety-Lab13.py):

- `WackyPackageCard` models one card and its owned quantity.
- `WackyPackageSeries` stores the catalog in a NumPy object array.
- `process_collection_information` normalizes whitespace and letter case before matching names.
- `collection_value` and `determine_missing_information` aggregate values and missing quantities.

The two small CSV files are the original bundled exercise inputs. They include mixed capitalization, repeated entries and unmatched names.

## Run

From the repository root, using a Python environment with NumPy installed:

```sh
cd coursework-showcase/card-collection
python -m pip install numpy
python Spencer-Colety-Lab13.py
```

The script prints the catalog, owned quantities, total collection value, missing-card count and the cost of the missing cards.

## Scope

This is a fixed-format exercise with 30 catalog entries. It assumes valid numbered catalog rows and available input files. Unmatched collection names are ignored; this is not a general-purpose CSV validator.

The source header dates the lab to November 28, 2023 and names Spencer Colety. Source and bundled data are preserved unchanged. [Source notes](../SOURCES.md) · [All projects](../README.md)
