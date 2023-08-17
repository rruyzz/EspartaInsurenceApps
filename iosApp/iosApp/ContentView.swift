import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
		Text(greet)
	}
}

struct ContentViewOther: View {
    let greet = Greeting().greet()

    var body: some View {
        Text("dsklfjkldsj")
    }
}