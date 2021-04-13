# Ratalyzer - RATings anALYZER

Ratalyzer analyzes product ratings from CSV and outputs statistics as JSON.

## Running

Ratalyzer reads input either from a file or stdin and similarly writes output either to a file or to stdout.

To read from a file, use the `--input-file` or `-i` switch:

```
sbt "run --input-file src/test/resources/input.csv" 
```

To write to a file, use the `--output-file` or `-o` switch:

```
sbt "run --input-file src/test/resources/input.csv --output-file foo.json" 
```

If either flag is omitted, corresponding IO defaults to stdin/stdout. This allows placing the tool as a part of a standard Unix pipeline. For example:

```
curl http://example.com/product-rating.csv | sbt -error run | jq .mostRatedProduct
```

## Contributing

### Running tests

```
sbt test
```

## Built with

- [Scallop](https://github.com/scallop/scallop)
- [refined](https://github.com/fthomas/refined)
- [kantan.csv](https://nrinaudo.github.io/kantan.csv/)
- [uPickle](https://github.com/com-lihaoyi/upickle)
- [MUnit](https://scalameta.org/munit/)

