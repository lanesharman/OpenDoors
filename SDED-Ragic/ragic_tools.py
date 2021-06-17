import requests
import pandas
import config

class RagicTools():
    def __init__(self, table_id, group_name, api):
        self.table_id = str(table_id)
        self.group_name = str(group_name)
        self.api = api
        self.url = 'https://www.ragic.com/ccedatabase/%s/%s?api&APIKey=%s' % (self.group_name, self.table_id, self.api)
    def get_table(self):
        '''
        gets table passed into constructor 
        '''
        r = requests.get(self.url)
        return r.json()
    
    def add_entry(self, entry):
        '''
        entry must look like this: 
        files = {
            '1000114': (None, '8'),
            '1000115': (None, 'column 1-2-3'),
            '1000116': (None, 'column 2-2'),
            '1000117': (None, 'column 3-2')
        }
        where the keys are the column ids that can be found in ragic
        adds entry to table
        '''
       
        r = requests.post(self.url, files = entry)
        return r.json()

    def delete_entry(self, row_id):
        '''
        deletes row in current table in 
        '''
        row_id = str(row_id)
        url = 'https://www.ragic.com/ccedatabase/%s/%s/%s?api&APIKey=%s' % (self.group_name, self.table_id, row_id, self.api)
        r = requests.delete(url)
        return r.json()

    def update_entry(self, row_id, updated_entry):
        '''
        updates given row with new data in group
        entry must look like this:
        updated_entry = {
            '1000114': (None, '9'),
            '1000115': (None, 'updated'),
            '1000116': (None, 'from'),
            '1000117': (None, 'script')
        }

        '''
        row_id = str(row_id)
        url = 'https://www.ragic.com/ccedatabase/%s/%s/%s?api&APIKey=%s' % (self.group_name, self.table_id, row_id, self.api)        
        r = requests.post(url, updated_entry)
        return r.json()
    
    def get_table_id(self):
        return self.table_id
    def get_group(self):
        return self.group_name

