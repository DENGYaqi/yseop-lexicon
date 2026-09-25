"""Read-only check for the restored local Lexicon browser and API."""

import json
import os
from urllib.request import urlopen


BASE = os.environ.get("LEXICON_BASE_URL", "http://127.0.0.1:18080")
PAGES = ["/", "/index", "/wordList", "/conceptList", "/word/1", "/concept/1"]


def get(path):
    with urlopen(BASE + path, timeout=20) as response:
        body = response.read()
        assert response.status == 200 and body, path
        return body


def main():
    for path in PAGES:
        get(path)
        print("OK", path)
    word = json.loads(get("/api/word/id/1"))
    concept = json.loads(get("/api/concept/id/1"))
    assert word["id"] == 1 and concept["id"] == 1
    print("OK /api/word/id/1 and /api/concept/id/1")


if __name__ == "__main__":
    main()
