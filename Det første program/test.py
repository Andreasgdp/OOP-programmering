class StringTokenizer:
    def __init__(self, source, delim="\n"):
        self.text = source
        self.delim = delim
        self.index = 0

    def is_delimiter(self, char):
        if char in self.delim:
            return True
        else:
            return False

    def has_more_tokens(self):
        return_value = False
        for i in range(self.index, len(self.text)):
            if not self.is_delimiter(self.text[i]):
                return_value = True
                break
            else:
                return_value = False
        return return_value

    def set_index(self, index):
        self.index = index

    def next_token(self, delimiters="default_value"):
        self.delim = self.delim if delimiters == "default_value" else delimiters

        return_value = ""
        if not self.has_more_tokens():
            return_value = ""
            if self.index < len(self.text):
                self.index += 1
        else:
            for i in range(self.index, len(self.text)):
                if not self.is_delimiter(self.text[i]):
                    return_value += self.text[i]
                elif self.is_delimiter(self.text[i]) and len(return_value) > 0:
                    self.index = i
                    break
        return return_value

    def count_tokens(self):
        counter = 0
        while_value = self.has_more_tokens()
        while while_value:
            while_value = self.has_more_tokens()
            self.next_token()
            counter += 1
        return counter


if __name__ == "__main__":
    test = StringTokenizer("Gid du var i Skanderborg og blev der, kaere Peter.", " ,.")

    test.set_index(6)
    print("Has more tokens: " + str(test.has_more_tokens()))
    print("Next token: " + str(test.next_token()))
    print("num tokens left: " + str(test.count_tokens()))
