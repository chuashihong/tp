---
layout: page
title: User Guide
---

AgentSee is a **desktop app for managing house selling clients and for quick filtering for a specific type of house to recommend to buyers, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AgentSee can get your contact management tasks done faster than traditional GUI apps.
* Table of Contents
{:toc}
--------------------------------------------------------------------------------------------------------------------
## Table of Contents
1. Quick start
2. Functions
3. Help
4. FAQ
5. Command Summary
## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest jar from [here](https://github.com/AY2122S2-CS2103T-T11-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AgenSee application.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a client named `John Doe` to the AgenSee contacts.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Functions

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a client: `add`

Adds a client to the contact list.

Format: `add n/NAME d/DESCRIPTION p/PHONE_NUMBER e/EMAIL a/ADDRESS r/REMARK [t/TAG]...`

Note: Must include n/ d/ p/ e/ a/ r/, t/ is optional

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A client can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe d/A student in NUS p/98765432 e/johnd@example.com a/John street, block 123, #01-01 r/Forgetful`
* `add n/Betsy Crowe d/From Malaysia t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 r/Dangerous t/criminal`

### Listing all clients : `list`

Shows a list of all clients in the contact list.

Format: `list`

### Editing a client : `edit`

Edits the fields of a client in the contact list.

### Sort all persons : `sort`

Sort all the person according to the orders specified

Currently it does not take any arguments after and it sorts the name of the clients alphabetically.
In the future it will be sorted according to the order of a specific field of an argument.

Format: 
`sort` default, sort the person by their names

`sort o/name` sort the person by their names

`sort o/appointment` sort the person by their appointment time 

Examples:
* `sort`
* `sort o/name`
* `sort o/appointment`



### Editing a person : `edit`

Edits an existing client in the contact list.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the client at the specified `INDEX`. The index refers to the index number shown in the displayed client list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the client will be removed i.e adding of tags is not cumulative.
* You can remove all the client’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st client to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd client to be `Betsy Crower` and clears all existing tags.


### Locating clients by name: `find`

Finds clients whose names contain any of the given keywords.
=======
### Locating clients: `find`

Finds clients whose selected field contain any of the given keywords.


Format: `find field/KEYWORD1 [MORE_KEYWORDS]`

* The fields are:
  * address `a/`
  * email `e/`
  * name `n/`
  * phone `p/`
* The search is **case-insensitive**. e.g `hans` will match `Hans`
* The **order** of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* All partial words will be matched e.g. `Han` keyword will match `Hans` in the name
* However, if the keyword is larger than any word in the field, it will not match e.g. `Hans` keyword will not match `Han` in name
* Clients matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find n/John` returns `john` and `John Doe`
* `find e/alex david` returns `alex123@gmail.com`, `david456@abc.com`<br>

### Deleting a client : `delete`

Deletes the specified client from the contact list.

Format: `delete INDEX`

* Deletes the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed client list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd client in the contact list.
* `find Betsy` followed by `delete 1` deletes the 1st client in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the contact list.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AgenSee data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AgenSee data are saved as a JSON file `[JAR file location]/data/agensee.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AgentSee will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AgenSee home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find prefix/ KEYWORD [MORE_KEYWORDS]`<br> e.g., `find n/ James Jake`
**List** | `list`
**Help** | `help`
